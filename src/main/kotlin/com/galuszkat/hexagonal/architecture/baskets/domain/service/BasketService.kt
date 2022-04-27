package com.galuszkat.hexagonal.architecture.baskets.domain.service

import com.galuszkat.hexagonal.architecture.baskets.domain.api.BasketApi
import com.galuszkat.hexagonal.architecture.baskets.domain.model.Basket
import com.galuszkat.hexagonal.architecture.baskets.domain.port.BasketMessageBrokerPort
import com.galuszkat.hexagonal.architecture.baskets.domain.port.BasketRepositoryPort
import com.galuszkat.hexagonal.architecture.products.domain.api.ProductApi
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class BasketService(
  private val repository: BasketRepositoryPort,
  private val messageBroker: BasketMessageBrokerPort,
  private val productApi: ProductApi,
) : BasketApi {

  override fun create(): Basket {
    logger.info { "Creating empty basket..." }
    val domain = Basket.new()

    repository.store(domain)
    messageBroker.publishCreated(domain)

    logger.info { "Created: $domain" }
    return domain
  }

  override fun delete(id: String) {
    logger.info { "Deleting basket for id: $id" }

    val basket = find(id)
    repository.delete(basket)
    messageBroker.publishDeleted(basket)

    logger.info { "Deleted: $basket" }
  }

  override fun find(id: String): Basket {
    logger.info { "Finding by id : $id" }

    val basket = repository.findById(id) ?: throw RuntimeException("not found for id: $id")

    return basket.also {
      logger.info { "Found for $id = $it" }
    }
  }

  override fun addProduct(id: String, productId: String): Basket {
    logger.info { "Adding for : $id and productId: $productId" }

    val basket: Basket = find(id)
    val newBasket = basket.copy(
      productList = basket.productList + productApi.find(productId)
    )

    repository.update(newBasket)
    messageBroker.publishUpdated(newBasket)

    return newBasket.also {
      logger.info { "Added for $id = $it" }
    }
  }

  override fun removeProduct(id: String, productId: String): Basket {
    logger.info { "Removing for : $id and productId: $productId" }

    val basket: Basket = find(id)
    val newBasket = basket.copy(
      productList = basket.productList.filter {it.id != productId }
    )

    repository.update(newBasket)
    messageBroker.publishUpdated(newBasket)

    return newBasket.also {
      logger.info { "Removed for : $id and productId: $productId = $newBasket" }
    }
  }
}
