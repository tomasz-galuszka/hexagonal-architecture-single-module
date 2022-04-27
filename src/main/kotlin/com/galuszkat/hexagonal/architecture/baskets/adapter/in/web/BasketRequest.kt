package com.galuszkat.hexagonal.architecture.baskets.adapter.`in`.web

import com.galuszkat.hexagonal.architecture.baskets.domain.model.Basket
import com.galuszkat.hexagonal.architecture.products.domain.model.Product

data class BasketRequest(
  val id: String,
  val productList: List<Product>
) {

  fun asBasket(): Basket {
    return Basket(
      id,
      productList,
    )
  }
}
