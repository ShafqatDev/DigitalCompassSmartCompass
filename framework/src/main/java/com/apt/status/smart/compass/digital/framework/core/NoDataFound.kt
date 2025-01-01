package com.apt.status.smart.compass.digital.framework.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.apt.status.smart.compass.digital.framework.core.MediumTextViewNoFont

@Composable
fun NoDataFound(
    modifier: Modifier = Modifier,
    text: String = "",
    buttonText: String = "Retry",
    onClick: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column {
            VerticalSpace()
            MediumTextViewNoFont(text = text)
            VerticalSpace(12)
            Button(onClick = {
                onClick.invoke()
            }) {
                MediumTextViewNoFont(text = buttonText)
            }
        }
    }
}