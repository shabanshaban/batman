package com.farad.entertainment.btmanfilm.di

import android.util.Log
import com.farad.entertainment.btmanfilm.utill.BASE_URL
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        val url = BASE_URL
        createRetrofit(
            get(named("default")),
            url,
        )
    }
    factory {
        val httpLoggingInterceptor = HttpLoggingInterceptor { message ->
            Log.d("XXXXXX APi SERVICE", message)
        }
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpLoggingInterceptor
    }


    single(named("default")) {


        val cacheSize = (50 * 1024 * 1024).toLong() // 50 MB
        val cache = Cache(androidApplication().cacheDir, cacheSize)


        val okhttpBuilder = OkHttpClient.Builder()
        okhttpBuilder
            .fastFallback(true)
            .cache(cache)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(get<HttpLoggingInterceptor>())
            .retryOnConnectionFailure(true)
            .pingInterval(3L, TimeUnit.SECONDS)


        okhttpBuilder.build()
    }

}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}


