package com.galuszkat.hexagonal.architecture.products.adapter.out.database

import com.galuszkat.hexagonal.architecture.products.domain.model.Product
import com.galuszkat.hexagonal.architecture.products.domain.port.ProductRepositoryPort
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class ProductRepositoryAdapter : ProductRepositoryPort {

  override fun store(product: Product) {
    logger.info { "Storing product: $product" }

    logger.info { "Stored product: $product" }
  }
}
