package com.aaquib.spring_security

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello() = "Spring Security Rocks!"

    @GetMapping("/bye")
    fun bye() = "Get lost!!"
}
