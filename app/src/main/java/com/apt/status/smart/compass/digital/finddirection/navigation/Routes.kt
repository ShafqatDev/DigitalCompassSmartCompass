package com.apt.status.smart.compass.digital.finddirection.navigation

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object MainScreen : Routes

    @Serializable
    data object LanguageScreen: Routes
}