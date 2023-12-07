package com.farad.entertainment.btmanfilm.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.farad.entertainment.btmanfilm.di.appModule
import com.farad.entertainment.btmanfilm.di.daoModule
import com.farad.entertainment.btmanfilm.di.dataSourceModule
import com.farad.entertainment.btmanfilm.di.dbModule
import com.farad.entertainment.btmanfilm.di.networkModule
import com.farad.entertainment.btmanfilm.di.repositoryModule
import com.farad.entertainment.btmanfilm.di.restModule
import com.farad.entertainment.btmanfilm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class BaseApp :Application() {


    override fun onCreate() {
        super.onCreate()
        initModule()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

    }
    private fun initModule() {


        startKoin {
            androidLogger()
            androidContext(this@BaseApp)
            modules(
                appModule,
                dbModule,
                daoModule,
                networkModule,
                repositoryModule,
                dataSourceModule,
                restModule,
                viewModelModule,
                module {
                    single { this@BaseApp.contentResolver }
                }
            )
        }
    }
}