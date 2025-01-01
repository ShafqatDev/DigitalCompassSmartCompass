package com.apt.status.smart.compass.digital.data.dto

import com.apt.status.smart.compass.digital.domain.model.LocalizeModel
import com.apt.status.smart.compass.digital.persistence.model.LanguageModel

fun LanguageModel.toLocalizeModel(): LocalizeModel {
    return LocalizeModel(
        name = this.name,
        subName = this.subName,
        shortCode = this.shortCode,
        flags = this.flags
    )
}