package com.galuszkat.hexagonal.architecture.baskets.adapter.out.messagebroker

import com.galuszkat.hexagonal.architecture.baskets.domain.model.Basket
import com.galuszkat.hexagonal.architecture.baskets.domain.port.BasketMessageBrokerPort
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class BasketMessageBrokerAdapter: BasketMessageBrokerPort {

  override fun publishCreated(basket: Basket) {
    logger.info { "Publishing create event: $basket" }

    logger.info { "Published create event: $basket" }
  }

  override fun publishUpdated(basket: Basket) {
    logger.info { "Publishing update event: $basket" }

    logger.info { "Published update event: $basket" }
  }

  override fun publishDeleted(basket: Basket) {
    logger.info { "Publishing delete event: $basket" }

    logger.info { "Published delete event: $basket" }
  }

}
