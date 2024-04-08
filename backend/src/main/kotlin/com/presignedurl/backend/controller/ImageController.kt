package com.presignedurl.backend.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/images")
class ImageController (

) {

    @PostMapping("/presignedUrls")
    fun createPresignedUrls () {

    }
}