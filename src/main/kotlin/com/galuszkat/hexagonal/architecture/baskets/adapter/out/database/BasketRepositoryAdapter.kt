package com.galuszkat.hexagonal.architecture.baskets.adapter.out.database

import com.galuszkat.hexagonal.architecture.baskets.domain.model.Basket
import com.galuszkat.hexagonal.architecture.baskets.domain.port.BasketRepositoryPort
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class BasketRepositoryAdapter : BasketRepositoryPort {

  private val storage = HashMap<String, Basket>()

  override fun store(basket: Basket): Basket {
    logger.info { "Storing entity: $basket" }

    storage[basket.id] = basket

    return storage[basket.id]!!.also {
      logger.info { "Stored entity: $it" }
    }
  }

  override fun findById(id: String): Basket? {
    logger.info { "Finding entity for: $id" }

    return storage[id].also {
      logger.info { "Found entity for: $id" }
    }
  }

  override fun update(basket: Basket) {
    logger.info { "Updating entity: $basket" }
    store(basket).also {
      logger.info { "Updated entity: $it" }
    }
  }

  override fun delete(basket: Basket) {
    logger.info { "Deleting entity: $basket" }

    storage.remove(basket.id).also {
      logger.info { "Deleted entity: $it" }
    }
  }
}
