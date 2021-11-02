package com.aaquib.springcloud.productservice.repository

import com.aaquib.springcloud.productservice.model.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepo : CrudRepository<Product, Long>
