package com.rasymptote.pizzashiftintensive.domain.model.pizza

data class PizzaConfiguration(
    val pizza: Pizza,
    val selectedToppings: Set<PizzaIngredient>,
    val selectedDough: PizzaDough,
    val selectedSize: PizzaSize,
)
