package com.apt.status.smart.compass.digital.data.repositoryImpl

import com.apt.status.smart.compass.digital.domain.repository.PreferencesRepository
import com.apt.status.smart.compass.digital.persistence.MyPrefs

class PreferencesRepositoryImpl(
    private val myPrefs: MyPrefs
) : PreferencesRepository {

    override var localeLanguageCode: String
        get() = myPrefs.localeLanguageCode?:"en"
        set(value) {
            myPrefs.localeLanguageCode = value
        }

    override var sessionCount: Int
        get() = myPrefs.sessionCount
        set(value) {
            myPrefs.sessionCount = value
        }
}
