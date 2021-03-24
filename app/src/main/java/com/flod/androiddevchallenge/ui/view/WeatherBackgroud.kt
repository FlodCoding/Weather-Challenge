/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.flod.androiddevchallenge.ui.view

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.flod.androiddevchallenge.model.WeatherType
import com.flod.androiddevchallenge.ui.component.backgroud.CloudBackground
import com.flod.androiddevchallenge.ui.component.backgroud.CloudyMoonBackground
import com.flod.androiddevchallenge.ui.component.backgroud.CloudySunBackground
import com.flod.androiddevchallenge.ui.component.backgroud.MoonBackground
import com.flod.androiddevchallenge.ui.component.backgroud.RainBackground
import com.flod.androiddevchallenge.ui.component.backgroud.SnowBackground
import com.flod.androiddevchallenge.ui.component.backgroud.SunnyBackground
import com.flod.androiddevchallenge.ui.theme.MyThemedPreview

@Composable
fun WeatherBackground(type: WeatherType) {

    val fillSize = Modifier.fillMaxSize()

    when (type) {
        // Maybe it will be more accurate according to the real time,
        // but it is only for demonstration at the moment
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

@Preview
@Composable
fun SunnyLightPreview() {
    MyThemedPreview {
        SunnyBackground(Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
fun MoonDarkPreview() {
    MyThemedPreview(true) {
        MoonBackground(Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
fun CloudyLightPreview() {
    MyThemedPreview {
        CloudySunBackground(Modifier.fillMaxSize())
    }
}

@Preview
@Composable
fun CloudyMoonDarkPreview() {
    MyThemedPreview(true) {
        CloudyMoonBackground(Modifier.fillMaxSize())
    }
}

@Preview
@Composable
fun OvercastLightPreview() {
    MyThemedPreview {
        CloudBackground(Modifier.fillMaxSize())
    }
}

@Preview
@Composable
fun OvercastDarkPreview() {
    MyThemedPreview(true) {
        CloudBackground(Modifier.fillMaxSize())
    }
}

@Preview
@Composable
fun RainLightPreview() {
    MyThemedPreview(false) {
        RainBackground(Modifier.fillMaxSize())
    }
}

@Preview
@Composable
fun RainDarkPreview() {
    MyThemedPreview(true) {
        RainBackground(Modifier.fillMaxSize())
    }
}

@Preview
@Composable
fun SnowLightPreview() {
    MyThemedPreview(false) {
        SnowBackground(Modifier.fillMaxSize())
    }
}

@Preview
@Composable
fun SnowDarkPreview() {
    MyThemedPreview(true) {
        SnowBackground(Modifier.fillMaxSize())
    }
}
