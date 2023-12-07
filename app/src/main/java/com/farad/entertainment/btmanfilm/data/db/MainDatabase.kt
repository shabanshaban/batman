package com.farad.entertainment.btmanfilm.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.farad.entertainment.btmanfilm.data.db.converter.SearchConverters
import com.farad.entertainment.btmanfilm.data.db.dao.BatmanDao
import com.farad.entertainment.btmanfilm.data.model.modeldb.FilmBatmanModelEntity


@Database(
    version = 1,
    exportSchema = false,
    entities =
    [

        FilmBatmanModelEntity::class,
    ],
)

@TypeConverters(
    SearchConverters::class,

)

abstract class MainDatabase : RoomDatabase() {
    abstract fun filmBatmanDao(): BatmanDao


}
