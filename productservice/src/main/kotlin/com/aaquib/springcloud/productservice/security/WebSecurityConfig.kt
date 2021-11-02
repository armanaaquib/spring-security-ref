package com.aaquib.springcloud.productservice.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class WebSecurityConfig: WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var userDetailsServiceImpl: UserDetailsServiceImpl

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsServiceImpl)
    }

    override fun configure(http: HttpSecurity) {
        http.httpBasic().and()
            .csrf().disable()
            .authorizeRequests()
            .mvcMatchers(HttpMethod.GET, "/product/api/products/{id:^[0-9]*$}").hasAnyRole("USER", "ADMIN")
            .mvcMatchers(HttpMethod.POST, "/product/api/products").hasRole("ADMIN")
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}
