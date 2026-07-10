package com.rasymptote.pizzashiftintensive.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.rasymptote.pizzashiftintensive.data.local.entity.CartEntity
import kotlinx.coroutines.flow.Flow

private const val CART_TABLE = "cart"

@Dao
interface CartDao {

    @Query("SELECT * FROM $CART_TABLE")
    fun getCart(): Flow<List<CartEntity>>

    @Insert
    suspend fun addCartItem(item: CartEntity)

    @Update
    suspend fun updateCartItem(item: CartEntity)

    @Query("DELETE FROM $CART_TABLE WHERE id = :id")
    suspend fun deleteCartItem(id: Int)

    @Query("DELETE FROM $CART_TABLE")
    suspend fun clearCart()
}