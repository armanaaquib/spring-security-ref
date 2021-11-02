package com.aaquib.spring_security

//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import org.springframework.stereotype.Component

@Component
//@Configuration
class MySecurityConfig(val myAuthenticationProvider: MyAuthenticationProvider) : WebSecurityConfigurerAdapter() {

//    @Autowired
//    private lateinit var passwordEncoder: BCryptPasswordEncoder

//    override fun configure(auth: AuthenticationManagerBuilder) {
////        val passwordEncoder = BCryptPasswordEncoder()
//        val user = User.withUsername("arman").password(passwordEncoder.encode("pwd")).authorities("read").build()
//        val userDetailsService = InMemoryUserDetailsManager()
//        userDetailsService.createUser(user)
//
////        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder)
//        auth.userDetailsService(userDetailsService)
//    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(myAuthenticationProvider)
    }

    override fun configure(http: HttpSecurity) {
        http.httpBasic()
//        http.formLogin()
//        http.authorizeRequests().antMatchers("/hello").authenticated().anyRequest().denyAll()
        http.authorizeRequests().antMatchers("/hello").authenticated()
        http.addFilterBefore(MySecurityFilter(), BasicAuthenticationFilter::class.java)
    }

//    @Bean
//    fun passwordEncoder() = BCryptPasswordEncoder()

}
