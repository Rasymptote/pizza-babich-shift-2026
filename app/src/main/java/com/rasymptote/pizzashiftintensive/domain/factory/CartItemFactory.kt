package com.rasymptote.pizzashiftintensive.domain.factory

import com.rasymptote.pizzashiftintensive.domain.model.cart.CartItem
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaConfiguration
import com.rasymptote.pizzashiftintensive.domain.usecase.pizza.CalculatePizzaPriceUseCase

class CartItemFactory(
    private val calculatePizzaPriceUseCase: CalculatePizzaPriceUseCase
) {

    fun create(
        configuration: PizzaConfiguration
    ): CartItem {

        return CartItem(
            pizzaId = configuration.pizza.id,
            pizzaName = configuration.pizza.name,
            imageUrl = configuration.pizza.imageUrl,
            selectedToppings = configuration.selectedToppings.map { it.type }.toSet(),
            selectedDough = configuration.selectedDough.type,
            selectedSize = configuration.selectedSize.type,
            quantity = 1,
            price = calculatePizzaPriceUseCase(configuration)
        )
    }
}