package com.galuszkat.hexagonal.architecture.products.adapter.`in`.web

import com.galuszkat.hexagonal.architecture.products.domain.model.Product
import java.math.BigDecimal

data class ProductResponse(
  private val id: String,
  private val name: String,
  private val stock: Int,
  private val priceAmount: BigDecimal,
  private val priceCurrency: String,
) {

  companion object {
    fun from(product: Product): ProductResponse {
      return ProductResponse(
        product.id,
        product.name,
        product.stock,
        product.priceAmount,
        product.priceCurrency,
      )
    }
  }
}
