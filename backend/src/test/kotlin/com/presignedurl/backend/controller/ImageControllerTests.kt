package com.presignedurl.backend.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.util.*
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
//@AutoConfigureMockRestServiceServer
@AutoConfigureMockMvc
class ImageControllerTests{

    @Autowired
    private lateinit var mockMvc: MockMvc

    private lateinit var controller:ImageController

    @BeforeEach
    fun setUp () {
            controller = ImageController()
            mockMvc = MockMvcBuilders.standaloneSetup(controller).build()
    }

    @Test
    fun `createPresignedUrls() を呼んだ時、200 OKとPresignedUrlのリスト型の返す`() {
//        every { mockedImageService.createPresignedUrls(any()) } returns PresignedUrlsResponse(
//            presignedUrls = listOf(
//                PresignedUrl("original1.jpeg", "http://url-1.jpeg?aws-credentials"),
//                PresignedUrl("original2.jpg", "http://url-2.jpg?aws-credentials"),
//                PresignedUrl("original3.png", "http://url-3.png?aws-credentials"),
//                PresignedUrl("original4.heif", "http://url-4.heif?aws-credentials"),
//                PresignedUrl("original5.heic", "http://url-5.heic?aws-credentials")
//            )
//        )
//        every { mockedAuthorityService.getPermissionsForUser(any()) } returns HacolabPermissions.fullPermissions

        mockMvc.perform(
//            MockMvcRequestBuilders.post("/api/images/presignedUrls")
            post("/api/images/presignedUrls")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """
                       {"files": [
                        {"contentType": "image/jpeg", "fileName": "original1.jpeg"},
                        {"contentType": "image/jpeg", "fileName": "original2.jpg"},
                        {"contentType": "image/png", "fileName": "original3.png"},
                        {"contentType": "image/heif", "fileName": "original4.heif"},
                        {"contentType": "image/heic", "fileName": "original5.heic"}
                       ]}
                        """.trimIndent()
                )
        )
            .andExpect(status().isOk)
//            .andExpect(MockMvcResultMatchers.jsonPath("$.presignedUrls[0].fileName").value("original1.jpeg"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.presignedUrls[0].url").value("http://url-1.jpeg?aws-credentials"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.presignedUrls[1].fileName").value("original2.jpg"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.presignedUrls[1].url").value("http://url-2.jpg?aws-credentials"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.presignedUrls[2].fileName").value("original3.png"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.presignedUrls[2].url").value("http://url-3.png?aws-credentials"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.presignedUrls[3].fileName").value("original4.heif"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.presignedUrls[3].url").value("http://url-4.heif?aws-credentials"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.presignedUrls[4].fileName").value("original5.heic"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.presignedUrls[4].url").value("http://url-5.heic?aws-credentials"))
//        verify {
//            mockedImageService.createPresignedUrls(
//                listOf(
//                    FileNameContentType("image/jpeg", "original1.jpeg"),
//                    FileNameContentType("image/jpeg", "original2.jpg"),
//                    FileNameContentType("image/png", "original3.png"),
//                    FileNameContentType("image/heif", "original4.heif"),
//                    FileNameContentType("image/heic", "original5.heic")
//                )
//            )
//        }
    }

}