package com.galuszkat.hexagonal.architecture.products.domain.port

import com.galuszkat.hexagonal.architecture.products.domain.model.Product

interface ProductMessageBrokerPort {

  fun publishCreated(product: Product)
}
