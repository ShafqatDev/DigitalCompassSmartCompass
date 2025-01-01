package com.apt.status.smart.compass.digital.domain.repository

interface PreferencesRepository {
    var localeLanguageCode: String
    var sessionCount: Int
}
