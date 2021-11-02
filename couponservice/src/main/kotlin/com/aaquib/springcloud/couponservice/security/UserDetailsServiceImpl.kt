package com.aaquib.springcloud.couponservice.security

import com.aaquib.springcloud.couponservice.repository.UserRepo
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(
    private val userRepo: UserRepo
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepo.findByEmail(username)
            ?: throw UsernameNotFoundException("user not found for email $username")
        return User(user.email, user.password, user.roles)
    }
}
