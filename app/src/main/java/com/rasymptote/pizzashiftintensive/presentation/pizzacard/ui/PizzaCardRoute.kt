package com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data class PizzaCardRoute(
    val pizzaId: String
) : NavKey {
}