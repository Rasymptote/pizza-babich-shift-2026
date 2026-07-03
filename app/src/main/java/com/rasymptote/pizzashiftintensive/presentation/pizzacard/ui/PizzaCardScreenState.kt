package com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui

import com.rasymptote.pizzashiftintensive.presentation.pizzacard.model.PizzaCard

sealed interface PizzaCardScreenState {
    data object Loading: PizzaCardScreenState

    data class Content(val pizzaCard: PizzaCard) : PizzaCardScreenState

    data class Error(val message: String) : PizzaCardScreenState
}