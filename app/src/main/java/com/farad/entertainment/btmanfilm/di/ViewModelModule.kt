package com.farad.entertainment.btmanfilm.di

import com.farad.entertainment.btmanfilm.ui.fragment.home.vm.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {

    viewModelOf(::HomeViewModel)
}