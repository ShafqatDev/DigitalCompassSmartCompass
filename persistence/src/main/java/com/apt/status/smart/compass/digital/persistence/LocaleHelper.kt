package com.apt.status.smart.compass.digital.persistence

import android.content.Context
import java.util.Locale

class LocaleHelper {
    fun setLocale(context: Context, sharePreference: MyPrefs): Context {
        try {
            return updateResources(context, sharePreference.localeLanguageCode ?: "en")
        } catch (_: Exception) {
        }
        return context
    }

    fun updateResources(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val configuration = context.resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)
        return context.createConfigurationContext(configuration)
    }

    fun updateResourcesLegacy(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = locale
        configuration.setLayoutDirection(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
        return context
    }

    fun onAttach(context: Context?, myPrefs: MyPrefs): Context? {
        return context?.let { setLocale(it, myPrefs) }
    }
}