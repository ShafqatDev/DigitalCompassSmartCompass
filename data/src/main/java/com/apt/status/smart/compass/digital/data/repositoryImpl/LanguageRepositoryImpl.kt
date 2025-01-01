package com.apt.status.smart.compass.digital.data.repositoryImpl

import com.apt.status.smart.compass.digital.data.dto.toLocalizeModel
import com.apt.status.smart.compass.digital.domain.model.LocalizeModel
import com.apt.status.smart.compass.digital.domain.repository.LanguageRepository
import com.apt.status.smart.compass.digital.persistence.LanguageHelper

class LanguageRepositoryImpl(private val languageHelper: LanguageHelper) : LanguageRepository {
    override fun getAllLanguages(): List<LocalizeModel> {
        return languageHelper.languagesList.map { it.toLocalizeModel() }
    }

    override fun getLocalizeLanguageNameByShortCode(shortCode:String): String {
        return languageHelper.getLocalizeLanguageNameByShortCode(shortCode = shortCode)
    }
}