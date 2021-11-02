package com.aaquib.spring_security

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class MyAuthenticationProvider : AuthenticationProvider {
    override fun authenticate(authentication: Authentication): Authentication {
        val username = authentication.name
        val password = authentication.credentials.toString()

        if ((username == "arman") and (password == "pwd")) {
            return UsernamePasswordAuthenticationToken(username, password, emptyList())
        } else {
            throw BadCredentialsException("username or password invalid")
        }
    }

    override fun supports(authentication: Class<*>): Boolean {
        return authentication.equals(UsernamePasswordAuthenticationToken::class.java)
    }
}
