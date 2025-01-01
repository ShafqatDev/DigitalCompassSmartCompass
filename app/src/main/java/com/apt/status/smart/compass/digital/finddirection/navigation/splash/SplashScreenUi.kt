package com.apt.status.smart.compass.digital.finddirection.navigation.splash

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.ImageLoader
import coil3.compose.rememberAsyncImagePainter
import coil3.gif.AnimatedImageDecoder
import coil3.gif.GifDecoder
import coil3.request.ImageRequest
import coil3.size.Size
import com.apt.status.smart.compass.digital.finddirection.R
import com.apt.status.smart.compass.digital.framework.core.VerticalSpace


@Composable
fun SplashScreenUi() {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(AnimatedImageDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.splashBgColor)),
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp)
                        .height(3.dp),
                    strokeCap = StrokeCap.Round,
                    color = colorResource(id = R.color.white)
                )
                VerticalSpace()
                Text(
                    text = "Loading",
                    fontSize = 16.sp,
                    color = Color.White
                )
                VerticalSpace()
                Text(
                    text = "This action may contain Ads",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.mainBgColor)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(300.dp),
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(context).data(data = R.drawable.splash_ic)
                            .apply(block = {
                                size(Size.ORIGINAL)
                            }).build(), imageLoader = imageLoader
                    ),
                    contentDescription = null
                )
            }
        }
    }

}