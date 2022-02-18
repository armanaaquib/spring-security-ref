package com.aaquib.springcloud.couponservice.controller

import com.aaquib.springcloud.couponservice.model.Coupon
import com.aaquib.springcloud.couponservice.repository.CouponRepo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class CouponController(private val couponRepo: CouponRepo) {

    @GetMapping("/")
    fun index() = "index"

    @GetMapping("/showCreateCoupon")
    fun showCreateCoupon() = "createCoupon"

    @PostMapping("/saveCoupon")
    fun save(coupon: Coupon): String {
        couponRepo.save(coupon)
        return "createResponse"
    }

    @GetMapping("/showGetCoupon")
    fun showGetCoupon() = "getCoupon"

    @PostMapping("/getCoupon")
    fun getCoupon(code: String): ModelAndView {
        val mv = ModelAndView("couponDetails")
        couponRepo.findByCode(code)?.let { mv.addObject(it) }
        return mv
    }
}
