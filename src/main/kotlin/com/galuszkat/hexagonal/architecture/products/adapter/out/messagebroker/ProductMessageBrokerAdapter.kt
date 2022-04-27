package com.galuszkat.hexagonal.architecture.products.adapter.out.messagebroker

import com.galuszkat.hexagonal.architecture.products.domain.model.Product
import com.galuszkat.hexagonal.architecture.products.domain.port.ProductMessageBrokerPort
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class ProductMessageBrokerAdapter: ProductMessageBrokerPort {

  override fun publishCreated(product: Product) {
    logger.info { "Publishing product: $product" }

    logger.info { "Published product: $product" }
  }

}
