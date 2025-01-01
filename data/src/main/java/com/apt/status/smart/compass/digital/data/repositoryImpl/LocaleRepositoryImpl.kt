package com.apt.status.smart.compass.digital.data.repositoryImpl

import android.content.Context
import com.apt.status.smart.compass.digital.domain.repository.LocaleRepository
import com.apt.status.smart.compass.digital.persistence.LocaleHelper
import com.apt.status.smart.compass.digital.persistence.MyPrefs

class LocaleRepositoryImpl(
    private val localeHelper: LocaleHelper,
    private val prefs: MyPrefs,
): LocaleRepository {
    override fun setLocale(context: Context, localeLanguageCode:String): Context {
        return localeHelper.setLocale(context = context, sharePreference = prefs)
    }

    override fun updateResources(context: Context, language: String): Context {
        return localeHelper.updateResources(context = context, language = language)
    }

    override fun updateResourcesLegacy(context: Context, language: String): Context {
        return localeHelper.updateResourcesLegacy(context = context, language = language)
    }

    override fun onAttach(context: Context?): Context? {
        return localeHelper.onAttach(context = context, myPrefs = prefs)
    }

}