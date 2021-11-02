package com.aaquib.spring_security

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

class MySecurityFilter : Filter {

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain) {
        println("before")
        chain.doFilter(request, response)
        println("after")
    }

}