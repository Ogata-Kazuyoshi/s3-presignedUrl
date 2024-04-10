import React, { useState } from 'react';
import axios from 'axios';

export const FileUpload: React.FC = () => {
    const [files, setFiles] = useState<File[]>([]);

    const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const filesData = event.target.files;
        if (filesData && filesData.length > 0) {
            setFiles(Array.from(filesData));
        }
    };

    const createReqestBody = () => {
        const typeAndName = files.map(elm => {
            return ({
                contentType: elm.type,
                fileName: elm.name
            })
        })
        return ({
            files : typeAndName
        })
    }

    const uploadFileToS3 = async () => {
        if (!files) {
            alert('ファイルが選択されていません。');
            return;
        }

        try {
            const reqBody = createReqestBody()

            const results: responsePresignedUrl[] = await axios.post('/api/images/presignedUrls', reqBody).then(elm => elm.data);

            for (const result of results) {
                const index = results.indexOf(result);
                await axios.put(result.url,files[index],{
                    headers: {
                        'Content-Type': files[index].type
                    }
                })
            }
            alert('ファイルのアップロードに成功しました。');
        } catch (error) {
            console.error('ファイルのアップロードに失敗しました。', error);
            alert('ファイルのアップロードに失敗しました。');
        }
    };

    return (
        <div>
            <input type="file" multiple={true} onChange={handleFileChange} />
            <button onClick={uploadFileToS3}>アップロード</button>
        </div>
    );
};

type responsePresignedUrl = {
    fileName:string,
    url:string
}
