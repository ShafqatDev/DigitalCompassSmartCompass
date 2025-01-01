package com.apt.status.smart.compass.digital.domain.repository

import com.apt.status.smart.compass.digital.domain.model.LocalizeModel

interface LanguageRepository {
    fun getAllLanguages(): List<LocalizeModel>
    fun getLocalizeLanguageNameByShortCode(shortCode:String): String
}