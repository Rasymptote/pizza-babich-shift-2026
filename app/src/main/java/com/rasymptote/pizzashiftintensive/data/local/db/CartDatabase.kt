package com.rasymptote.pizzashiftintensive.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rasymptote.pizzashiftintensive.data.local.dao.CartDao
import com.rasymptote.pizzashiftintensive.data.local.db.converter.DoughConverter
import com.rasymptote.pizzashiftintensive.data.local.db.converter.IngredientConverter
import com.rasymptote.pizzashiftintensive.data.local.db.converter.SizeConverter
import com.rasymptote.pizzashiftintensive.data.local.entity.CartEntity

@Database(
    entities = [CartEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    IngredientConverter::class,
    SizeConverter::class,
    DoughConverter::class
)
abstract class CartDatabase : RoomDatabase() {
    abstract fun cartDao() : CartDao
}