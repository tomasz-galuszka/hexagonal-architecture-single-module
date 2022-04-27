package com.galuszkat.hexagonal.architecture.products.domain

import com.galuszkat.hexagonal.architecture.products.domain.model.Product
import com.galuszkat.hexagonal.architecture.products.domain.port.ProductMessageBrokerPort
import com.galuszkat.hexagonal.architecture.products.domain.port.ProductRepositoryPort
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class ProductService(
  private val repository: ProductRepositoryPort,
  private val messageBroker: ProductMessageBrokerPort,
) {

  fun create(domain: Product): Product {
    logger.info { "Creating domain: $domain" }

    repository.store(domain)
    messageBroker.publishCreated(domain)

    return domain.also {
      logger.info { "Created domain: $it" }
    }
  }

  fun find(id: String): Product {
    logger.info { "Finding for id : $id" }

    val product = repository.findById(id) ?: throw RuntimeException("not found for id: $id")

    return product.also {
      logger.info { "Found for id : $id = $it" }
    }
  }
}
