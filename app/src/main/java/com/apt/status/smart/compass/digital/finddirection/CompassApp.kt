package com.apt.status.smart.compass.digital.finddirection

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import com.apt.status.smart.compass.digital.data.di.dataModules
import com.apt.status.smart.compass.digital.domain.repository.LocaleRepository
import com.apt.status.smart.compass.digital.persistence.di.persistenceModule
import com.apt.status.smart.compass.digital.presentation.di.presentationModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CompassApp : Application(){
    private val localeRepository: LocaleRepository by inject()
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(presentationModule)
            modules(dataModules)
            modules(persistenceModule)
        }
    }

    override fun attachBaseContext(base: Context?) {
        try {
            super.attachBaseContext(localeRepository.onAttach(base))
        } catch (e: Exception) {
            super.attachBaseContext(base)
        }
    }
}