package com.galuszkat.hexagonal.architecture.products.adapter.`in`.web

import com.galuszkat.hexagonal.architecture.products.adapter.`in`.web.model.ProductRequest
import com.galuszkat.hexagonal.architecture.products.adapter.`in`.web.model.ProductResponse
import com.galuszkat.hexagonal.architecture.products.domain.ProductService
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class ProductApiService(
  private val productService: ProductService
) {

  fun create(request: ProductRequest): ProductResponse {
    val domain = request.asProduct()
    logger.info { "Converted to domain: $domain" }

    val createdProduct = productService.create(domain)

    val response = ProductResponse.from(createdProduct)

    logger.info { "Converted to response: $response" }
    return response
  }
}
