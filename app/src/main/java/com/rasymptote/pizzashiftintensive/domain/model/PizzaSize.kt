package com.rasymptote.pizzashiftintensive.domain.model

data class PizzaSize(
    val type: Size,
    val price: Int,
) {
    val diameter: Int
        get() = when (type) {
            Size.SMALL -> 25
            Size.MEDIUM -> 30
            Size.LARGE -> 35
        }
}
