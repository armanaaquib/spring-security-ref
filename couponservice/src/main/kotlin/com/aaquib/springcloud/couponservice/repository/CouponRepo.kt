package com.aaquib.springcloud.couponservice.repository

import com.aaquib.springcloud.couponservice.model.Coupon
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CouponRepo : CrudRepository<Coupon, Long> {
    fun findByCode(code: String): Coupon?
}
