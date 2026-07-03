package com.rasymptote.pizzashiftintensive.presentation.pizzacard.mapper

import com.rasymptote.pizzashiftintensive.domain.usecase.PricedPizza
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.model.PizzaCard

fun PricedPizza.toScreenModel() = PizzaCard(
    this.pizza,
    selectedToppings = emptyList(),
    selectedDough = pizza.doughs.first(),
    selectedSize = pizza.sizes.first(),
    price = price
)