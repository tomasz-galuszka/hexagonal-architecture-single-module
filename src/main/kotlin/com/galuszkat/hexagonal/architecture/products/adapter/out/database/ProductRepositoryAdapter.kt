package com.galuszkat.hexagonal.architecture.products.adapter.out.database

import com.galuszkat.hexagonal.architecture.products.domain.model.Product
import com.galuszkat.hexagonal.architecture.products.domain.port.ProductRepositoryPort
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class ProductRepositoryAdapter : ProductRepositoryPort {

  private val storage = HashMap<String, Product>()

  override fun store(product: Product): Product {
    logger.info { "Storing entity: $product" }

    storage[product.id] = product

    return storage[product.id]!!.also {
      logger.info { "Stored entity: $it" }
    }
  }

  override fun findById(id: String): Product? {
    logger.info { "Finding entity for: $id" }

    return storage[id].also {
      logger.info { "Found entity for: $id" }
    }
  }
}
