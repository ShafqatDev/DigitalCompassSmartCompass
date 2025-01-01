package com.apt.status.smart.compass.digital.finddirection.navigation

import androidx.navigation.NavController

class AppDestinations(
    navController: NavController,
) {

    val popBack: () -> Unit = {
        navController.popBackStack()
    }
    val navigateToLanguageScreen: () -> Unit = {
        navController.navigate(Routes.LanguageScreen)
    }
}