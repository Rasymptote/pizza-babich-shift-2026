package com.rasymptote.pizzashiftintensive.data.mapper

import com.rasymptote.pizzashiftintensive.data.remote.dto.PizzaCatalogResponseDto
import com.rasymptote.pizzashiftintensive.data.remote.dto.PizzaComponentDto
import com.rasymptote.pizzashiftintensive.data.remote.dto.PizzaDto
import com.rasymptote.pizzashiftintensive.data.remote.dto.PizzaOptionDto
import com.rasymptote.pizzashiftintensive.di.ImageBaseUrl
import com.rasymptote.pizzashiftintensive.domain.model.Dough
import com.rasymptote.pizzashiftintensive.domain.model.Ingredient
import com.rasymptote.pizzashiftintensive.domain.model.Pizza
import com.rasymptote.pizzashiftintensive.domain.model.PizzaDough
import com.rasymptote.pizzashiftintensive.domain.model.PizzaIngredient
import com.rasymptote.pizzashiftintensive.domain.model.PizzaSize
import com.rasymptote.pizzashiftintensive.domain.model.Size
import jakarta.inject.Inject
import okhttp3.HttpUrl

class PizzaMapper @Inject constructor(
    @param:ImageBaseUrl
    private val imageBaseUrl: HttpUrl
) {

    fun map(response: PizzaCatalogResponseDto): List<Pizza> =
        response.catalog.map(::map)

    fun map(dto: PizzaDto): Pizza =
        Pizza(
            id = dto.id,
            name = dto.name,
            ingredients = dto.ingredients.map(::mapIngredient),
            toppings = dto.toppings.map(::mapIngredient),
            description = dto.description,
            sizes = dto.sizes.map(::mapSize),
            doughs = dto.doughs.map(::mapDough),
            calories = dto.calories,
            protein = dto.protein,
            totalFat = dto.totalFat,
            carbohydrates = dto.carbohydrates,
            sodium = dto.sodium,
            allergens = dto.allergens,
            isVegetarian = dto.isVegetarian,
            isGlutenFree = dto.isGlutenFree,
            isNew = dto.isNew,
            isHit = dto.isHit,
            imageUrl = buildImageUrl(dto.img)
        )

    private fun mapIngredient(dto: PizzaComponentDto): PizzaIngredient =
        PizzaIngredient(
            type = Ingredient.valueOf(dto.type.uppercase()),
            price = dto.price,
            imageUrl = buildImageUrl(dto.img)
        )

    private fun mapSize(dto: PizzaOptionDto): PizzaSize =
        PizzaSize(
            type = Size.valueOf(dto.type.uppercase()),
            price = dto.price
        )

    private fun mapDough(dto: PizzaOptionDto): PizzaDough =
        PizzaDough(
            type = Dough.valueOf(dto.type.uppercase()),
            price = dto.price
        )

    private fun buildImageUrl(path: String): String =
        imageBaseUrl.newBuilder()
            .addEncodedPathSegments(path.removePrefix("/"))
            .build()
            .toString()
}