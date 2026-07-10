package com.rasymptote.pizzashiftintensive.data.repository

import com.rasymptote.pizzashiftintensive.data.local.dao.CartDao
import com.rasymptote.pizzashiftintensive.data.mapper.toDomain
import com.rasymptote.pizzashiftintensive.data.mapper.toEntity
import com.rasymptote.pizzashiftintensive.domain.model.cart.CartItem
import com.rasymptote.pizzashiftintensive.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val cartDao: CartDao
) : CartRepository {

    override fun getCart(): Flow<List<CartItem>> {
        return cartDao.getCart().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun addCartItem(item: CartItem) {
        cartDao.addCartItem(item.toEntity())
    }

    override suspend fun updateCartItem(item: CartItem) {
        cartDao.updateCartItem(item.toEntity())
    }

    override suspend fun deleteCartItem(id: Int) {
        cartDao.deleteCartItem(id)
    }

    override suspend fun clearCart() {
        cartDao.clearCart()
    }
}