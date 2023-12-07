package com.farad.entertainment.btmanfilm.di


import com.farad.entertainment.btmanfilm.data.remote.HomeApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create


val restModule = module {

    single<HomeApi> { (get<Retrofit>()).create() }
}