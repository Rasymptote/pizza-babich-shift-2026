package com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.model

data class PizzaScreenModel(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val initialPrice: Int
)