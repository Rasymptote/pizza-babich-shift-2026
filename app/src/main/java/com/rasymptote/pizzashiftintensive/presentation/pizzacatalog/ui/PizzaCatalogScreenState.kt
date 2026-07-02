package com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.ui

import com.rasymptote.pizzashiftintensive.domain.model.Pizza

sealed interface PizzaCatalogScreenState {
    data object Loading: PizzaCatalogScreenState

    data class Content(val pizzas: List<Pizza>) : PizzaCatalogScreenState

    data class Error(val message: String) : PizzaCatalogScreenState
}