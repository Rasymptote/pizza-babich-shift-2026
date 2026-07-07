package com.rasymptote.pizzashiftintensive.presentation.pizzacard.model

import com.rasymptote.pizzashiftintensive.domain.model.pizza.Pizza
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaDough
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaIngredient
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaSize

data class PizzaCard(
    val pizza: Pizza,
    val selectedToppings: Set<PizzaIngredient>,
    val selectedDough: PizzaDough,
    val selectedSize: PizzaSize,
    val price: Int
)