package com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.ui

import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.model.PizzaScreenModel

sealed interface PizzaCatalogScreenState {
    data object Loading: PizzaCatalogScreenState

    data class Content(val pizzas: List<PizzaScreenModel>) : PizzaCatalogScreenState

    data class Error(val message: String) : PizzaCatalogScreenState
}