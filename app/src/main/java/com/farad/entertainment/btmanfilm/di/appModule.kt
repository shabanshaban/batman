package com.farad.entertainment.btmanfilm.di

import android.os.Handler
import android.os.Looper
import com.farad.entertainment.btmanfilm.app.BaseApp
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val appModule = module {
    single { Handler(Looper.getMainLooper()) }
    single { androidApplication() as BaseApp }


}