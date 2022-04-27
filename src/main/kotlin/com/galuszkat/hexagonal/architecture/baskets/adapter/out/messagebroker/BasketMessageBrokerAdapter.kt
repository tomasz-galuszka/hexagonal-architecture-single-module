package com.galuszkat.hexagonal.architecture.baskets.adapter.out.messagebroker

import com.galuszkat.hexagonal.architecture.baskets.domain.model.Basket
import com.galuszkat.hexagonal.architecture.baskets.domain.port.BasketMessageBrokerPort
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class BasketMessageBrokerAdapter: BasketMessageBrokerPort {

  override fun publishCreated(basket: Basket) {
    logger.info { "Publishing event: $basket" }

    logger.info { "Published event: $basket" }
  }

  override fun publishUpdated(basket: Basket) {
    logger.info { "Publishing event: $basket" }

    logger.info { "Published event: $basket" }
  }

}
