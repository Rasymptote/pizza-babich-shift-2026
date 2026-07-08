package com.rasymptote.pizzashiftintensive.domain.usecase.cart

import com.rasymptote.pizzashiftintensive.domain.model.cart.CartItem
import com.rasymptote.pizzashiftintensive.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow

class ObserveCartItemsUseCase(
    private val cartRepository: CartRepository
) {
    operator fun invoke() : Flow<List<CartItem>> = cartRepository.getCart()
}