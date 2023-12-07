package com.farad.entertainment.btmanfilm.di

import com.farad.entertainment.btmanfilm.data.dataSource.DataSourceLocalHome
import com.farad.entertainment.btmanfilm.data.dataSource.DataSourceLocalRemote
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val dataSourceModule = module {
    singleOf(::DataSourceLocalHome)
    singleOf(::DataSourceLocalRemote)
}