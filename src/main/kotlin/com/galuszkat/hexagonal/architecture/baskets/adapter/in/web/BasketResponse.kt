package com.galuszkat.hexagonal.architecture.baskets.adapter.`in`.web

import com.galuszkat.hexagonal.architecture.baskets.domain.model.Basket
import com.galuszkat.hexagonal.architecture.products.adapter.`in`.web.ProductResponse

data class BasketResponse(
  val id: String,
  val productList: List<ProductResponse>
) {

  companion object {
    fun from(basket: Basket): BasketResponse {
      return BasketResponse(
        basket.id,
        basket.productList.map { ProductResponse.from(it) }.toList(),
      )
    }
  }
}
