package com.rasymptote.pizzashiftintensive.domain.usecase.pizza

import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaConfiguration

class CalculatePizzaPriceUseCase {
    operator fun invoke(pizzaConfiguration: PizzaConfiguration): Int =
        pizzaConfiguration.selectedSize.price +
                pizzaConfiguration.selectedDough.price +
                pizzaConfiguration.selectedToppings.sumOf { it.price }
}