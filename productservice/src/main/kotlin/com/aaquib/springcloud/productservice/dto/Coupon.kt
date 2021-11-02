package com.aaquib.springcloud.productservice.dto

import java.math.BigDecimal

data class Coupon(
    val id: Long,
    val code: String,
    val discount: BigDecimal,
    val expDate: String
)
