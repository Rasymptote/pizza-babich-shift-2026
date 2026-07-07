package com.rasymptote.pizzashiftintensive.domain.model.pizza

data class PizzaIngredient(
    val type: Ingredient,
    val price: Int,
    val imageUrl: String,
)
