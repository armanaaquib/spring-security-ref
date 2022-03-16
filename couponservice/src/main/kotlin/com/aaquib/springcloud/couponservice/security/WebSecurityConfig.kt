package com.aaquib.springcloud.couponservice.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var userDetailsServiceImpl: UserDetailsServiceImpl

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsServiceImpl)
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .mvcMatchers(
                HttpMethod.GET,
                "/coupon/api/coupons/{code:^[A-Z]*$}",
                "/showGetCoupon"
            ).hasAnyRole("USER", "ADMIN")
            .antMatchers(HttpMethod.POST, "/getCoupon").hasAnyRole("USER", "ADMIN")
            .antMatchers(HttpMethod.GET, "/showCreateCoupon").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "/coupon/api/coupons", "/saveCoupon").hasRole("ADMIN")
            .mvcMatchers("/", "/login", "/logout", "/showReg", "registerUser").permitAll()
            .anyRequest().denyAll()
            .and().csrf().disable()
            .logout().logoutSuccessUrl("/")
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}
