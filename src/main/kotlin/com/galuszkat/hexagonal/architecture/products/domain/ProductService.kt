package com.galuszkat.hexagonal.architecture.products.domain

import com.galuszkat.hexagonal.architecture.products.domain.model.Product
import com.galuszkat.hexagonal.architecture.products.domain.port.ProductMessageBrokerPort
import com.galuszkat.hexagonal.architecture.products.domain.port.ProductRepositoryPort
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class ProductService(
  private val productRepository: ProductRepositoryPort,
  private val messageBroker: ProductMessageBrokerPort,
) {

  fun create(product: Product): Product {
    logger.info { "Creating product: $product" }

    productRepository.store(product)
    messageBroker.publishCreated(product)

    logger.info { "Created product: $product" }

    return product
  }
}
