package com.rasymptote.pizzashiftintensive.domain.usecase

import com.rasymptote.pizzashiftintensive.domain.model.Pizza

data class PricedPizza(
    val pizza: Pizza,
    val price: Int
)
