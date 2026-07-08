package com.rasymptote.pizzashiftintensive.data.local.db.converter

import androidx.room.TypeConverter
import com.rasymptote.pizzashiftintensive.domain.model.pizza.Ingredient

class IngredientConverter {

    @TypeConverter
    fun fromIngredients(value: Set<Ingredient>): String {
        return value.joinToString(",") { it.name }
    }

    @TypeConverter
    fun toIngredients(value: String): Set<Ingredient> {
        if (value.isEmpty()) return emptySet()

        return value.split(",")
            .map { Ingredient.valueOf(it) }
            .toSet()
    }
}