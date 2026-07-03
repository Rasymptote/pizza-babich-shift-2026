package com.rasymptote.pizzashiftintensive.presentation.pizzacard.model

import com.rasymptote.pizzashiftintensive.domain.model.Pizza
import com.rasymptote.pizzashiftintensive.domain.model.PizzaDough
import com.rasymptote.pizzashiftintensive.domain.model.PizzaIngredient
import com.rasymptote.pizzashiftintensive.domain.model.PizzaSize

data class PizzaCard(
    val pizza: Pizza,
    val selectedToppings: List<PizzaIngredient>,
    val selectedDough: PizzaDough,
    val selectedSize: PizzaSize,
    val price: Int
)