package com.rasymptote.pizzashiftintensive.domain.repository

import com.rasymptote.pizzashiftintensive.domain.model.cart.CartItem
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun getCart(): Flow<List<CartItem>>

    suspend fun addCartItem(item: CartItem)

    suspend fun updateCartItem(item: CartItem)

    suspend fun deleteCartItem(id: Int)

    suspend fun clearCart()
}