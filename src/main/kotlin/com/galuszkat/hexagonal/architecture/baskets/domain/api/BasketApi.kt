package com.galuszkat.hexagonal.architecture.baskets.domain.api

import com.galuszkat.hexagonal.architecture.baskets.domain.model.Basket

interface BasketApi {
  fun create(): Basket
  fun delete(id: String)
  fun find(id: String): Basket
  fun addProduct(id: String, productId: String): Basket
  fun removeProduct(id: String, productId: String): Basket
}
