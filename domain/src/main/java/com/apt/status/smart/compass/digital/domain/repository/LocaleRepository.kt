package com.apt.status.smart.compass.digital.domain.repository

import android.content.Context

interface LocaleRepository {
    fun setLocale(context: Context, localeLanguageCode: String): Context
    fun updateResources(context: Context, language: String): Context
    fun updateResourcesLegacy(context: Context, language: String): Context
    fun onAttach(context: Context?): Context?
}