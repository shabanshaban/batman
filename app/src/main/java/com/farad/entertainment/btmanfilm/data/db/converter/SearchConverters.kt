package com.farad.entertainment.btmanfilm.data.db.converter

import androidx.room.TypeConverter
import com.farad.entertainment.btmanfilm.data.model.BatmanSearch
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SearchConverters {


    @TypeConverter
    fun fromString(value: String): List<BatmanSearch> {
        val listType = object : TypeToken<List<BatmanSearch>>() {}.type
        return Gson().fromJson(value, listType) ?: arrayListOf()
    }

    @TypeConverter
    fun toString(model: List<BatmanSearch>): String {
        return Gson().toJson(model)
    }

}