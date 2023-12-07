package com.farad.entertainment.btmanfilm.di


import com.farad.entertainment.btmanfilm.data.repository.HomeRepository
import com.farad.entertainment.btmanfilm.data.repository.HomeRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {

    singleOf(::HomeRepositoryImpl) { bind<HomeRepository>() }
}