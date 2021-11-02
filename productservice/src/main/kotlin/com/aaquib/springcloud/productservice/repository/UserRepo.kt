package com.aaquib.springcloud.productservice.repository

import com.aaquib.springcloud.productservice.model.PcUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepo: JpaRepository<PcUser, Long> {
    fun findByEmail(username: String): PcUser?
}
