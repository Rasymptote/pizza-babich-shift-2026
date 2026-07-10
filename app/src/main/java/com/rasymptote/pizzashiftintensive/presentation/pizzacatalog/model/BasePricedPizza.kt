package com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.model

import com.rasymptote.pizzashiftintensive.domain.model.pizza.Pizza

data class BasePricedPizza(
    val pizza: Pizza,
    val basePrice: Int
)
