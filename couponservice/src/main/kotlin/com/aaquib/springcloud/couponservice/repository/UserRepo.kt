package com.aaquib.springcloud.couponservice.repository

import com.aaquib.springcloud.couponservice.model.PcUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepo: JpaRepository<PcUser, Long> {
    fun findByEmail(email: String): PcUser?
}
