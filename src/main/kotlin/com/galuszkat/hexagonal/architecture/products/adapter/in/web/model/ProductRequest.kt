package com.galuszkat.hexagonal.architecture.products.adapter.`in`.web.model

import com.galuszkat.hexagonal.architecture.products.domain.model.Product
import java.math.BigDecimal
import java.util.UUID

data class ProductRequest(
  private val name: String,
  private val stock: Int,
  private val priceAmount: BigDecimal,
  private val priceCurrency: String,
) {

  fun asProduct(): Product {
    return Product(
      id = UUID.randomUUID().toString(),
      name,
      stock,
      priceAmount,
      priceCurrency
    )
  }
}
