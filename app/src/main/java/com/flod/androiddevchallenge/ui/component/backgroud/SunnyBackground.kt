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

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SunnyBackground(
    modifier: Modifier,
    color: Color = Color(0xFFFFC30F)
) {

    val fraction by rememberInfiniteTransition().animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            repeatMode = RepeatMode.Restart,
            animation = tween(
                durationMillis = 10000,
                easing = LinearEasing
            ),
        )
    )

    Canvas(modifier = modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val radius = canvasWidth * 0.25f
        val inc = density * 60
        val center = Offset(size.width * 0.95f, radius * 0.3f)

        drawCircle(color.copy(alpha = 0.07f - 0.07f * fraction), radius + (3 + fraction) * inc, center)
        drawCircle(color.copy(alpha = 0.1f - 0.03f * fraction), radius + (2 + fraction) * inc, center)
        drawCircle(color.copy(alpha = 0.2f - 0.1f * fraction), radius + (1 + fraction) * inc, center)
        drawCircle(color.copy(alpha = 0.3f - 0.1f * fraction), radius + inc * fraction, center)
        drawCircle(color, radius, center)
    }
}

@Preview
@Composable
fun SunnyBackgroundPreview() {
    SunnyBackground(Modifier.fillMaxSize())
}
