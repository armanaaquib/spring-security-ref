package com.aaquib.springcloud.productservice.controller

import com.aaquib.springcloud.productservice.dto.Coupon
import com.aaquib.springcloud.productservice.model.Product
import com.aaquib.springcloud.productservice.repository.ProductRepo
import com.aaquib.springcloud.productservice.servce.ProductService
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import java.math.BigDecimal

@RestController
@RequestMapping("/product/api")
class ProductController(
    private val productService: ProductService,
    @Value("\${couponService.url}")
    private val couponServiceBaseURL: String
) {
    @PostMapping("/products")
    fun create(@RequestBody product: Product) = productService.saveProduct(product)

    @GetMapping("/products/{id}")
    fun get(@PathVariable id: Long) = productService.getProduct(id)
}
