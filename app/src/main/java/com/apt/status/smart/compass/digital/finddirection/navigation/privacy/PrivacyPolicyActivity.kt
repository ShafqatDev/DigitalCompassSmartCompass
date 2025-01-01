package com.apt.status.smart.compass.digital.finddirection.navigation.privacy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.apt.status.smart.compass.digital.finddirection.presentation.screens.privacy.PrivacyPolicyScreen

class PrivacyPolicyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrivacyPolicyScreen()
        }
    }
}