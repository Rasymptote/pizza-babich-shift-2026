package com.rasymptote.pizzashiftintensive.data.mapper

import com.rasymptote.pizzashiftintensive.data.local.entity.CartEntity
import com.rasymptote.pizzashiftintensive.domain.model.cart.CartItem

fun CartEntity.toDomain(): CartItem {
    return CartItem(
        id = id,
        pizzaId = pizzaId,
        pizzaName = pizzaName,
        imageUrl = imageUrl,
        selectedSize = selectedSize,
        selectedDough = selectedDough,
        selectedToppings = selectedToppings,
        quantity = quantity,
        price = price
    )
}

fun CartItem.toEntity(): CartEntity {
    return CartEntity(
        id = id ?: 0,
        pizzaId = pizzaId,
        pizzaName = pizzaName,
        imageUrl = imageUrl,
        selectedSize = selectedSize,
        selectedDough = selectedDough,
        selectedToppings = selectedToppings,
        quantity = quantity,
        price = price
    )
}