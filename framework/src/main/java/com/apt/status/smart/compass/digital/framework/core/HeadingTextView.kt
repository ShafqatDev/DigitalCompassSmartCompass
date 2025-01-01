package com.apt.status.smart.compass.digital.framework.core

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun MediumTextViewNoFont(
    text: String,
    fontSize: Int = 13,
    color: Color = Color.Black,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = (fontSize * 1.3).sp,
        color = color,
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}

@Composable
fun SmallTextViewNoFont(
    text: String,
    fontSize: Int = 11,
    color: Color = Color.Black,
    onClick: (() -> Unit)? = null,
    shouldVerticalScroll: Boolean = false
) {
    val scroll =
        if (shouldVerticalScroll) Modifier.verticalScroll(rememberScrollState()) else Modifier
    onClick?.let {
        TextButton(
            onClick = {
                onClick.invoke()
            },
        ) {
            Text(
                text = text,
                fontSize = (fontSize * 1.3).sp,
                color = color,
            )
        }
    } ?: run {
        Text(
            text = text,
            fontSize = (fontSize * 1.3).sp,
            color = color,
            modifier = scroll,
        )
    }
}