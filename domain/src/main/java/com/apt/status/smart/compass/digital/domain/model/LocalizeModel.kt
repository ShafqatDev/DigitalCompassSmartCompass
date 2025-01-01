
package com.apt.status.smart.compass.digital.domain.model

//import com.apt.status.smart.compass.digital.finddirection.utils.LanguageHelper

data class LocalizeModel(
    val name: String,
    val subName: String,
    val shortCode: String,
    val flags: String,
)

////fun String.getLocalizeLanguageNameByShortCode() = LanguageHelper.localizeLanguagesList.firstOrNull {
////    it.shortCode == this
//}?.name ?: LanguageHelper.localizeLanguagesList[0].name