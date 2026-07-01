package com.rasymptote.pizzashiftintensive.data.mapper

import com.rasymptote.pizzashiftintensive.data.remote.dto.PizzaCatalogResponseDto
import com.rasymptote.pizzashiftintensive.data.remote.dto.PizzaComponentDto
import com.rasymptote.pizzashiftintensive.data.remote.dto.PizzaDto
import com.rasymptote.pizzashiftintensive.data.remote.dto.PizzaOptionDto
import com.rasymptote.pizzashiftintensive.domain.model.Dough
import com.rasymptote.pizzashiftintensive.domain.model.Ingredient
import com.rasymptote.pizzashiftintensive.domain.model.Pizza
import com.rasymptote.pizzashiftintensive.domain.model.PizzaDough
import com.rasymptote.pizzashiftintensive.domain.model.PizzaIngredient
import com.rasymptote.pizzashiftintensive.domain.model.PizzaSize
import com.rasymptote.pizzashiftintensive.domain.model.Size

fun PizzaCatalogResponseDto.toPizzas() : List<Pizza> {
    return catalog.map {
        it.toPizza()
    }
}

fun PizzaDto.toPizza() = Pizza(
    id = id,
    name = name,
    ingredients = ingredients.map { it.toPizzaIngredient() },
    toppings = toppings.map { it.toPizzaIngredient() },
    description = description,
    sizes = sizes.map { it.toPizzaSize() },
    doughs = doughs.map { it.toPizzaDough() },
    calories = calories,
    protein = protein,
    totalFat = totalFat,
    carbohydrates = carbohydrates,
    sodium = sodium,
    allergens = allergens,
    isVegetarian = isVegetarian,
    isGlutenFree = isGlutenFree,
    isNew = isNew,
    isHit = isHit,
    img = img
)

fun PizzaComponentDto.toPizzaIngredient() : PizzaIngredient = PizzaIngredient(
    type = Ingredient.valueOf(type.uppercase()),
    price = price,
    img = img
)

fun PizzaOptionDto.toPizzaSize() : PizzaSize = PizzaSize(
    type = Size.valueOf(type.uppercase()),
    price = price
)

fun PizzaOptionDto.toPizzaDough() : PizzaDough = PizzaDough(
    type = Dough.valueOf(type.uppercase()),
    price = price
)
