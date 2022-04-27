package com.galuszkat.hexagonal.architecture.baskets.domain.port

import com.galuszkat.hexagonal.architecture.baskets.domain.model.Basket

interface BasketMessageBrokerPort {
  fun publishCreated(basket: Basket)
  fun publishUpdated(basket: Basket)
  fun publishDeleted(basket: Basket)
}
