package com.galuszkat.hexagonal.architecture.products.adapter.`in`.web.controller

import com.galuszkat.hexagonal.architecture.products.adapter.`in`.web.model.ProductRequest
import com.galuszkat.hexagonal.architecture.products.adapter.`in`.web.model.ProductResponse
import com.galuszkat.hexagonal.architecture.products.domain.ProductService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("products")
class ProductController(
  private val productService: ProductService
) {

  @PostMapping
  fun create(@RequestBody request: ProductRequest): ProductResponse {
    logger.info { "Request: $request" }
    val domain = request.asProduct()

    val createdProduct = productService.create(domain)
    val response = ProductResponse.from(createdProduct)

    logger.info { "Response: $response" }
    return response
  }
}
