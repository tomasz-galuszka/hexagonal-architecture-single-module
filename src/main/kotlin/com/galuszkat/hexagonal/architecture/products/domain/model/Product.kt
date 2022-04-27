package com.galuszkat.hexagonal.architecture.products.domain.model

import java.math.BigDecimal

data class Product(
  val id: String,
  val name: String,
  val stock: Int,
  val priceAmount: BigDecimal,
  val priceCurrency: String,
)
