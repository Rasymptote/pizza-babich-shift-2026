package com.rasymptote.pizzashiftintensive.domain.mapper

import com.rasymptote.pizzashiftintensive.domain.model.pizza.Pizza
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaConfiguration

fun Pizza.toPizzaConfiguration(): PizzaConfiguration {
    return PizzaConfiguration(
        pizza = this,
        selectedSize = this.sizes.first(),
        selectedDough = this.doughs.first(),
        selectedToppings = emptySet()
    )
}