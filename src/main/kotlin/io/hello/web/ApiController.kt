package io.hello.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v0")
@RestController
class ApiController {

    @GetMapping("/hello")
    fun hello(): String {
        return "hell";
    }
}