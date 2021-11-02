package com.aaquib.springcloud.couponservice.repository

import com.aaquib.springcloud.couponservice.model.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepo: JpaRepository<Role, Long>