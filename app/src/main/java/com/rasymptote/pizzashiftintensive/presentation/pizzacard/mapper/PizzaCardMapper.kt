package com.rasymptote.pizzashiftintensive.presentation.pizzacard.mapper

import com.rasymptote.pizzashiftintensive.domain.model.Pizza
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.model.PizzaCard

fun Pizza.toPizzaCard(basePrice: Int) = PizzaCard(
    this,
    selectedToppings = emptySet(),
    selectedDough = doughs.first(),
    selectedSize = sizes.first(),
    price = basePrice
)