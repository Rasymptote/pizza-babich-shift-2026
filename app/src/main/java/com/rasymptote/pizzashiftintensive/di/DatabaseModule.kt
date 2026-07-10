package com.rasymptote.pizzashiftintensive.di

import android.content.Context
import androidx.room.Room
import com.rasymptote.pizzashiftintensive.data.local.db.CartDatabase
import com.rasymptote.pizzashiftintensive.data.local.dao.CartDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideCartDatabase(
        @ApplicationContext context: Context
    ): CartDatabase =
        Room.databaseBuilder(
            context = context,
            klass = CartDatabase::class.java,
            name = "cart.db"
        ).build()

    @Provides
    fun provideCartDao(
        database: CartDatabase
    ): CartDao = database.cartDao()
}