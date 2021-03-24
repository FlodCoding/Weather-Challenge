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
package com.flod.androiddevchallenge.ui.component.backgroud

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.flod.androiddevchallenge.ui.theme.MyThemedPreview

@Composable
fun CloudySunBackground(
    modifier: Modifier,
    sunColor: Color = Color(0x95F5CD58),
    cloudColor: Color = Color(0xFFA5E4FF)
) {

    CloudBackground(modifier = modifier, color = cloudColor)

    Canvas(modifier) {

        val canvasWidth = size.width

        // draw sun ☀️
        val sunRadius = canvasWidth * 0.25f
        val sunCenter = Offset(size.width * 0.95f, sunRadius * 0.3f)
        drawCircle(sunColor, sunRadius, sunCenter)
    }
}

@Preview
@Composable
fun CloudyLightPreview() {
    MyThemedPreview {
        CloudySunBackground(Modifier.fillMaxSize())
    }
}
