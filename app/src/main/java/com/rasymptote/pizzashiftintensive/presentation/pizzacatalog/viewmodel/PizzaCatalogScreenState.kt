package com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.viewmodel

import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.model.BasePricedPizza

sealed interface PizzaCatalogScreenState {

    data object Initial: PizzaCatalogScreenState

    data object Loading: PizzaCatalogScreenState

    data class Content(val pizzas: List<BasePricedPizza>) : PizzaCatalogScreenState

    data class Error(val message: String) : PizzaCatalogScreenState
}