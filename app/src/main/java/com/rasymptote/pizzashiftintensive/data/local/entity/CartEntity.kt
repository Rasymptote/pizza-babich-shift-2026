package com.rasymptote.pizzashiftintensive.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rasymptote.pizzashiftintensive.domain.model.pizza.Dough
import com.rasymptote.pizzashiftintensive.domain.model.pizza.Ingredient
import com.rasymptote.pizzashiftintensive.domain.model.pizza.Size

@Entity(tableName = "cart")
data class CartEntity(
    @PrimaryKey(autoGenerate = true)
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