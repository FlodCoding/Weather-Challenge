package com.flod.androiddevchallenge.ui.view

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.flod.androiddevchallenge.model.WeatherType
import com.flod.androiddevchallenge.ui.component.backgroud.*

@Composable
fun WeatherBackground(type: WeatherType) {

    val fillSize = Modifier.fillMaxSize()

    when (type) {
        //Maybe it will be more accurate according to the real time,
        //but it is only for demonstration at the moment
        WeatherType.Sunny -> {
            if (isSystemInDarkTheme()) {
                MoonBackground(fillSize)
            } else {
                SunnyBackground(fillSize)
            }
        }
        WeatherType.Cloudy -> {
            if (isSystemInDarkTheme()) {
                CloudyMoonBackground(fillSize)
            } else {
                CloudySunBackground(fillSize)
            }
        }
        WeatherType.Overcast -> CloudBackground(fillSize)
        WeatherType.Rain -> RainBackground(fillSize)
        WeatherType.Snow -> SnowBackground(fillSize)
        WeatherType.Undefined -> {
        }
    }

}
