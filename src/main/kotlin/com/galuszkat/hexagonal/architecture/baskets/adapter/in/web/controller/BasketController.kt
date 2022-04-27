package com.galuszkat.hexagonal.architecture.baskets.adapter.`in`.web.controller

import com.galuszkat.hexagonal.architecture.baskets.adapter.`in`.web.BasketResponse
import com.galuszkat.hexagonal.architecture.baskets.domain.BasketService
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
  private val basketService: BasketService
) {

  @PostMapping
  fun create(): BasketResponse {
    logger.info { "Request empty" }

    return basketService.create()
      .let { BasketResponse.from(it) }
      .also { logger.info { "Response: $it" } }
  }

  @GetMapping("/{id}")
  fun find(@PathVariable id: String): BasketResponse {
    logger.info { "Request: $id" }

    return basketService.find(id)
      .let { BasketResponse.from(it) }
      .also { logger.info { "Response: $it" } }
  }

  @DeleteMapping("/{id}/remove/{productId}")
  fun removeProduct(@PathVariable id: String, @PathVariable productId: String): BasketResponse {
    logger.info { "Request: $id and $productId" }

    return basketService.removeProduct(id, productId)
      .let { BasketResponse.from(it) }
      .also { logger.info { "Response: $it" } }
  }

  @PutMapping("/{id}/add/{productId}")
  fun addProduct(@PathVariable id: String, @PathVariable productId: String): BasketResponse {
    logger.info { "Request: $id and $productId" }

    return basketService.addProduct(id, productId)
      .let { BasketResponse.from(it) }
      .also { logger.info { "Response: $it" } }
  }
}
