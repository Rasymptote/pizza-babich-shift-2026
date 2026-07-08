package com.rasymptote.pizzashiftintensive.domain.usecase.pizza

import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaConfiguration

class CalculatePizzaPriceUseCase {
    operator fun invoke(pizzaConfiguration: PizzaConfiguration) : Int {
        var price = pizzaConfiguration.selectedSize.price
        price += pizzaConfiguration.selectedDough.price
        pizzaConfiguration.selectedToppings.forEach {
            price += it.price
        }

        return price
    }
}