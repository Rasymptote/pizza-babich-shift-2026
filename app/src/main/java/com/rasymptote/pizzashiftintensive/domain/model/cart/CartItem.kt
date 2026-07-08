package com.rasymptote.pizzashiftintensive.domain.model.cart

import com.rasymptote.pizzashiftintensive.domain.model.pizza.Dough
import com.rasymptote.pizzashiftintensive.domain.model.pizza.Ingredient
import com.rasymptote.pizzashiftintensive.domain.model.pizza.Size

data class CartItem(
    val id: Int,
    val pizzaId: String,
    val pizzaName: String,
    val imageUrl: String,
    val selectedToppings: Set<Ingredient>,
    val selectedDough: Dough,
    val selectedSize: Size,
    val quantity: Int,
    val price: Int
)
