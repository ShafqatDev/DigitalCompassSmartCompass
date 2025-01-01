package com.apt.status.smart.compass.digital.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import com.apt.status.smart.compass.digital.presentation.language.LanguageViewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::LanguageViewModel)
}