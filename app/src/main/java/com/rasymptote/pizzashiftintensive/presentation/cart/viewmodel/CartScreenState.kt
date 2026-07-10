package com.rasymptote.pizzashiftintensive.presentation.cart.viewmodel

import com.rasymptote.pizzashiftintensive.domain.model.cart.CartItem

sealed interface CartScreenState {
    data object Initial: CartScreenState

    data class Content(
        val items: List<CartItem>
    ) : CartScreenState

}