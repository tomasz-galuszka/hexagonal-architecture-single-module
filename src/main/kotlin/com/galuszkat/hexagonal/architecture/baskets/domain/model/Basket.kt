package com.galuszkat.hexagonal.architecture.baskets.domain.model

import com.galuszkat.hexagonal.architecture.products.domain.model.Product
import java.util.LinkedList
import java.util.UUID

data class Basket(
  val id: String,
  val productList: List<Product>
) {

  companion object {
    fun new() = Basket(
      UUID.randomUUID().toString(),
      LinkedList<Product>()
    )
  }
}
