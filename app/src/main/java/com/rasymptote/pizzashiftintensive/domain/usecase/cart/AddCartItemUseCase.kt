package com.rasymptote.pizzashiftintensive.domain.usecase.cart

import com.rasymptote.pizzashiftintensive.domain.factory.CartItemFactory
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaConfiguration
import com.rasymptote.pizzashiftintensive.domain.repository.CartRepository

class AddCartItemUseCase(
    private val cartRepository: CartRepository,
    private val cartItemFactory: CartItemFactory
) {
    suspend operator fun invoke(configuration: PizzaConfiguration) {
        val item = cartItemFactory.create(configuration)
        cartRepository.addCartItem(item)
    }
}