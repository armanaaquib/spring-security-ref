package com.aaquib.springcloud.couponservice.security

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class SecurityServiceImp(
    private val userDetailsService: UserDetailsService,
    private val authenticationManager: AuthenticationManager
) {

    fun login(username: String, password: String): Boolean {
        val userDetails = userDetailsService.loadUserByUsername(username)
        val authenticationToken =
            UsernamePasswordAuthenticationToken(userDetails, password, userDetails.authorities)
        authenticationManager.authenticate(authenticationToken)

        return if (authenticationToken.isAuthenticated) {
            SecurityContextHolder.getContext().authentication = authenticationToken
            println("Logged In")
            true
        } else false
    }
}
