package com.aaquib.springcloud.couponservice.controller

import com.aaquib.springcloud.couponservice.model.Coupon
import com.aaquib.springcloud.couponservice.repository.CouponRepo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/coupon/api")
class CouponController(
    private val couponRepo: CouponRepo
) {

    @PostMapping("/coupons")
    fun create(@RequestBody coupon: Coupon) = couponRepo.save(coupon)

    @GetMapping("/coupons/{code}")
    fun get(@PathVariable code: String): Coupon? = couponRepo.findByCode(code)
}
