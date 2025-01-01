package com.apt.status.smart.compass.digital.finddirection.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.apt.status.smart.compass.digital.domain.repository.PreferencesRepository
import com.apt.status.smart.compass.digital.presentation.language.LanguageScreen
import com.apt.status.smart.compass.digital.presentation.main.MainScreen
import org.koin.compose.koinInject

@Composable
fun TestApp(
    fromSplash: Boolean = false,
) {
    val navController = rememberNavController()

    val appDestinations by remember {
        mutableStateOf(AppDestinations(navController))
    }
//    val startDestination by remember {
//        mutableStateOf(
//            if (!fromSplash) {
//                Routes.LanguageScreen
//            } else {
//                Routes.MainScreen
//            }
//        )
//    }
    NavHost(
        navController = navController, startDestination = Routes.LanguageScreen
    ) {
        composable<Routes.MainScreen> {
            MainScreen()
        }
        composable<Routes.LanguageScreen> {
            LanguageScreen(
//                fromSplash = fromSplash
            )
        }
    }
}