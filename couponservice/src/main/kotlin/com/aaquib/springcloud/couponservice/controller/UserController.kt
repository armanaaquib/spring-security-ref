package com.aaquib.springcloud.couponservice.controller

import com.aaquib.springcloud.couponservice.model.PcUser
import com.aaquib.springcloud.couponservice.repository.UserRepo
import com.aaquib.springcloud.couponservice.security.SecurityServiceImp
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import kotlin.math.log

@Controller
class UserController(
    private val securityService: SecurityServiceImp,
    private val userRepo: UserRepo,
    private val encoder: PasswordEncoder
) {

    @GetMapping("/showReg")
    fun showRegPage() = "registerUser"

    @PostMapping("/registerUser")
    fun register(user: PcUser): String {
        user.password = encoder.encode(user.password)
        userRepo.save(user)
        return "login"
    }

    @GetMapping("/")
    fun showLoginPage() = "login"

    @PostMapping("/login")
    fun login(email: String, password: String): String {
        val login = securityService.login(email, password)
        return if (login) "index" else "/"
    }

}