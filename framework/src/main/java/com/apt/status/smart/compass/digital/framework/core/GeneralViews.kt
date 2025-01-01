package com.apt.status.smart.compass.digital.framework.core

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp


@Composable
fun VerticalSpace(space: Int = 10) {
    Spacer(
        modifier = Modifier
            .height((space).dp)
    )
}

@Composable
fun HorizontalSpace(space: Int = 10) {
    Spacer(
        modifier = Modifier
            .width((space).dp)
    )
}

@Composable
fun KeepScreenOn() {
    val currentView = LocalView.current
    DisposableEffect(Unit) {
        currentView.keepScreenOn = true
        onDispose {
            currentView.keepScreenOn = false
        }
    }
}
