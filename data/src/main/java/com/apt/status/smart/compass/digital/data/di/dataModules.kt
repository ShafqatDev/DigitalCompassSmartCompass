package com.apt.status.smart.compass.digital.data.di

import com.apt.status.smart.compass.digital.data.repositoryImpl.LanguageRepositoryImpl
import com.apt.status.smart.compass.digital.data.repositoryImpl.LocaleRepositoryImpl
import com.apt.status.smart.compass.digital.data.repositoryImpl.PreferencesRepositoryImpl
import com.apt.status.smart.compass.digital.domain.repository.LanguageRepository
import com.apt.status.smart.compass.digital.domain.repository.LocaleRepository
import com.apt.status.smart.compass.digital.domain.repository.PreferencesRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModules = module {
    factoryOf(::PreferencesRepositoryImpl) { bind<PreferencesRepository>() }
    factoryOf(::LanguageRepositoryImpl) { bind<LanguageRepository>() }
    factoryOf(::LocaleRepositoryImpl) { bind<LocaleRepository>() }
}