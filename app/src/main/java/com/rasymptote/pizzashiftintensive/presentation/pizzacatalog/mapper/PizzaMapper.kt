package com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.mapper

import com.rasymptote.pizzashiftintensive.domain.usecase.PizzaWithBasePrice
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.model.PizzaScreenModel

fun PizzaWithBasePrice.toScreenModel() : PizzaScreenModel = PizzaScreenModel(
    id = pizza.id,
    name = pizza.name,
    description = pizza.description,
    imageUrl = pizza.imageUrl,
    initialPrice = price
)