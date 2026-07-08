package com.rasymptote.pizzashiftintensive.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.rasymptote.pizzashiftintensive.data.local.entity.CartEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Query("SELECT * FROM cart")
    fun getCart(): Flow<List<CartEntity>>

    @Insert
    suspend fun addCartItem(item: CartEntity)

    @Update
    suspend fun updateCartItem(item: CartEntity)

    @Query("DELETE FROM cart WHERE id = :id")
    suspend fun deleteCartItem(id: Int)

    @Query("DELETE FROM cart")
    suspend fun clearCart()
}