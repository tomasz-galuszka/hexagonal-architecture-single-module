package com.galuszkat.hexagonal.architecture.products.adapter.`in`.web.model

import com.galuszkat.hexagonal.architecture.products.domain.model.Product
import java.math.BigDecimal

data class ProductRequest(
  private val id: String,
  private val name: String,
  private val stock: Int,
  private val priceAmount: BigDecimal,
  private val priceCurrency: String,
) {

  fun asProduct(): Product {
    return Product(
      id,
      name,
      stock,
      priceAmount,
      priceCurrency
    )
  }
}
