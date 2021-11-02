package com.aaquib.spring_security

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder

@SpringBootTest
class FirstappApplicationTests {

    @Test
    fun contextLoads() {
    }

    @Test
    fun testPasswordEncoder() {
        println(BCryptPasswordEncoder().encode("pwd"))
        println(Pbkdf2PasswordEncoder().encode("pwd"))
        println(SCryptPasswordEncoder().encode("pwd"))
    }
}
