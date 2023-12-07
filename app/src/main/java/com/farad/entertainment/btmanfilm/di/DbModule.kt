package com.farad.entertainment.btmanfilm.di


import androidx.room.Room
import com.farad.entertainment.btmanfilm.data.db.MainDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbModule = module {


    single {
        Room.databaseBuilder(androidApplication(), MainDatabase::class.java, "btmanDb")
            .build()
    }
}