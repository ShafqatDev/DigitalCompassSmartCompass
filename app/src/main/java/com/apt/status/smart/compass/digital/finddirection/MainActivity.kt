package com.apt.status.smart.compass.digital.finddirection

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.apt.status.smart.compass.digital.domain.repository.PreferencesRepository
import com.apt.status.smart.compass.digital.finddirection.navigation.TestApp
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
//    private var fromSplash = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestApp(fromSplash = true)
        }
    }
}