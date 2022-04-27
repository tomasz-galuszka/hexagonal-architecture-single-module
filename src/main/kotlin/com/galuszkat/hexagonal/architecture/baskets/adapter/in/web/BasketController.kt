package com.galuszkat.hexagonal.architecture.baskets.adapter.`in`.web

import com.galuszkat.hexagonal.architecture.baskets.domain.api.BasketApi
import mu.KotlinLogging
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("baskets")
class BasketController(
  private val basketApi: BasketApi
) {

  @PostMapping
  fun create(): BasketResponse {
    logger.info { "Request empty" }

    return basketApi.create()
      .let { BasketResponse.from(it) }
      .also { logger.info { "Response: $it" } }
  }

  @GetMapping("/{id}")
  fun find(@PathVariable id: String): BasketResponse {
    logger.info { "Request: $id" }

    return basketApi.find(id)
      .let { BasketResponse.from(it) }
      .also { logger.info { "Response: $it" } }
  }

  @DeleteMapping("/{id}")
  fun delete(@PathVariable id: String) {
    logger.info { "Request: $id" }
    return basketApi.delete(id)
  }

  @DeleteMapping("/{id}/remove/{productId}")
  fun removeProduct(@PathVariable id: String, @PathVariable productId: String): BasketResponse {
    logger.info { "Request: $id and $productId" }

    return basketApi.removeProduct(id, productId)
      .let { BasketResponse.from(it) }
      .also { logger.info { "Response: $it" } }
  }

  @PutMapping("/{id}/add/{productId}")
  fun addProduct(@PathVariable id: String, @PathVariable productId: String): BasketResponse {
    logger.info { "Request: $id and $productId" }

    return basketApi.addProduct(id, productId)
      .let { BasketResponse.from(it) }
      .also { logger.info { "Response: $it" } }
  }
}
