package com.apt.status.smart.compass.digital.persistence.di

import com.apt.status.smart.compass.digital.persistence.LanguageHelper
import com.apt.status.smart.compass.digital.persistence.LocaleHelper
import com.apt.status.smart.compass.digital.persistence.MyPrefs
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val persistenceModule = module {
    factoryOf(::MyPrefs)
    factoryOf(::LocaleHelper)
    factoryOf(::LanguageHelper)
}