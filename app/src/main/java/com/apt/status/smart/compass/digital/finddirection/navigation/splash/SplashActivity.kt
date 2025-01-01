package com.apt.status.smart.compass.digital.finddirection.navigation.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import com.apt.status.smart.compass.digital.domain.repository.PreferencesRepository
import com.apt.status.smart.compass.digital.finddirection.MainActivity
import com.apt.status.smart.compass.digital.framework.core.KeepScreenOn
import kotlinx.coroutines.delay
import org.koin.android.ext.android.inject

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    private val prefs:PreferencesRepository by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KeepScreenOn()
            SplashScreenUi()
            LaunchedEffect(Unit) {
                delay(5000)
                launchMain()
            }
        }
    }

    private var mainLaunched = false
    private fun launchMain() {
        if (mainLaunched) {
            return
        }
        mainLaunched = true
        if (prefs.sessionCount ==0){
            Intent(this, MainActivity::class.java).putExtra("fromSplash", false)
        }else{
            startActivity(
                Intent(this, MainActivity::class.java).putExtra("fromSplash", true)
            )
        }
        finish()
    }
}