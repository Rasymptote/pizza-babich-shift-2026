package com.rasymptote.pizzashiftintensive.presentation.extension

import androidx.annotation.StringRes
import com.rasymptote.pizzashiftintensive.R
import com.rasymptote.pizzashiftintensive.domain.model.Ingredient

@StringRes
fun Ingredient.titleRes(): Int = when (this) {
    Ingredient.HAM -> R.string.ingredient_ham
    Ingredient.MUSHROOMS -> R.string.ingredient_mushrooms
    Ingredient.FETA -> R.string.ingredient_feta
    Ingredient.GREEN_PEPPER -> R.string.ingredient_green_pepper
    Ingredient.MOZZARELLA -> R.string.ingredient_mozzarella
    Ingredient.BACON -> R.string.ingredient_bacon
    Ingredient.BASIL -> R.string.ingredient_basil
    Ingredient.CHILE -> R.string.ingredient_chile
    Ingredient.ONION -> R.string.ingredient_onion
    Ingredient.TOMATO -> R.string.ingredient_tomato
    Ingredient.CHEDDAR -> R.string.ingredient_cheddar
    Ingredient.PEPPERONI -> R.string.ingredient_pepperoni
    Ingredient.SHRIMP -> R.string.ingredient_shrimp
    Ingredient.PICKLE -> R.string.ingredient_pickle
    Ingredient.PARMESAN -> R.string.ingredient_parmesan
    Ingredient.MEATBALLS -> R.string.ingredient_meatballs
    Ingredient.PINEAPPLE -> R.string.ingredient_pineapple
    Ingredient.CHICKEN_FILLET -> R.string.ingredient_chicken_fillet
}