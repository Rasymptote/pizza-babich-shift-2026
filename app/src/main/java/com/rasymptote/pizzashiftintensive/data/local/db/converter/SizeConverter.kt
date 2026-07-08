package com.rasymptote.pizzashiftintensive.data.local.db.converter

import androidx.room.TypeConverter
import com.rasymptote.pizzashiftintensive.domain.model.pizza.Size

class SizeConverter {

    @TypeConverter
    fun fromSize(value: Size): String {
        return value.name
    }

    @TypeConverter
    fun toSize(value: String): Size {
        return Size.valueOf(value)
    }
}