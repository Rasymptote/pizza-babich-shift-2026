package com.rasymptote.pizzashiftintensive.presentation.pizzacard.viewmodel

import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaConfiguration


sealed interface PizzaCardScreenState {

    data object Initial: PizzaCardScreenState

    data object Loading: PizzaCardScreenState

    data class Content(
        val pizzaConfiguration: PizzaConfiguration,
        val price: Int
    ) : PizzaCardScreenState

    data class Error(val message: String) : PizzaCardScreenState
}