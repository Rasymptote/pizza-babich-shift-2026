package com.rasymptote.pizzashiftintensive.data.local.db.converter

import androidx.room.TypeConverter
import com.rasymptote.pizzashiftintensive.domain.model.pizza.Dough

class DoughConverter {

    @TypeConverter
    fun fromDough(value: Dough): String {
        return value.name
    }

    @TypeConverter
    fun toDough(value: String): Dough {
        return Dough.valueOf(value)
    }
}