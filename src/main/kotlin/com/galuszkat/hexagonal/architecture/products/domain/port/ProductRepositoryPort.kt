package com.galuszkat.hexagonal.architecture.products.domain.port

import com.galuszkat.hexagonal.architecture.products.domain.model.Product

interface ProductRepositoryPort {

  fun store(product: Product)
}
