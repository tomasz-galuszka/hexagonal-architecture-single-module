package com.galuszkat.hexagonal.architecture.baskets.domain.port

import com.galuszkat.hexagonal.architecture.baskets.domain.model.Basket

interface BasketRepositoryPort {
  fun store(basket: Basket): Basket
  fun findById(id: String): Basket?
  fun update(basket: Basket)
  fun delete(basket: Basket)
}
s
