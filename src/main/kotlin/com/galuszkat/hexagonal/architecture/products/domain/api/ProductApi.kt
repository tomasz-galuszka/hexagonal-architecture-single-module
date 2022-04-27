package com.galuszkat.hexagonal.architecture.products.domain.api

import com.galuszkat.hexagonal.architecture.products.domain.model.Product

interface ProductApi {

  fun create(domain: Product): Product

  fun find(id: String): Product
}
