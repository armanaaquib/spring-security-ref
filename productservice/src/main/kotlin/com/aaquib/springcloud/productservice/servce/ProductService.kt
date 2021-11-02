package com.aaquib.springcloud.productservice.servce

import com.aaquib.springcloud.productservice.dto.Coupon
import com.aaquib.springcloud.productservice.model.Product
import com.aaquib.springcloud.productservice.repository.ProductRepo
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.math.BigDecimal

@Service
class ProductService(
    private val productRepo: ProductRepo,
    private val restTemplate: RestTemplate,
    @Value("\${couponService.url}")
    private val couponServiceBaseURL: String
) {
    fun getProduct(id: Long) = productRepo.findById(id)

    fun saveProduct(product: Product): Product {
        val coupon = restTemplate.getForObject(
            "$couponServiceBaseURL/${product.couponCode}",
            Coupon::class.java
        )
        product.price = product.price - (coupon?.discount ?: BigDecimal(0))
        return productRepo.save(product)
    }
}
