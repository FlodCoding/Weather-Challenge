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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.withSaveLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MoonBackground(
    modifier: Modifier,
    showStar: Boolean = true,
    moonColor: Color = Color(0xFFEBEBD5),
    starColor: Color = Color.White
) {

    val fraction by rememberInfiniteTransition().animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            repeatMode = RepeatMode.Reverse,
            animation = tween(
                durationMillis = 2000,
                easing = LinearEasing
            ),
        )
    )

    val stars: List<StarObject>? = if (showStar) {
        List(20) {
            StarObject.randomCreate(
                range = Rect(0f, 0f, 1f, 0.3f),
                radiusDpRange = 1..3,
                alphaPercentRange = 10..100
            )
        }
    } else null

    Canvas(modifier = modifier) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        // draw star
        stars?.forEach {
            val radius = it.size.toPx()
            val center = Offset(canvasWidth * it.multipleX, canvasHeight * it.multipleY)
            val incAlpha = fraction + it.alpha
            val alpha = if (incAlpha < 1) incAlpha else 2 - incAlpha
            drawCircle(starColor, radius, center, alpha = alpha)
        }

        // draw moon

        val moonRadius = canvasWidth * 0.25f
        val offset = density * 30
        val moonCenter = Offset(canvasWidth - moonRadius + offset, moonRadius - offset)
        val clearCenter = Offset(canvasWidth + offset, -offset)
        val clearRadius = moonRadius * 1.3f

        drawContext.canvas.withSaveLayer(Rect(moonCenter, moonRadius), Paint()) {
            drawCircle(moonColor, moonRadius, moonCenter)
            drawCircle(Color(0xFF000000), clearRadius, clearCenter, blendMode = BlendMode.Clear)
        }
    }
}

class StarObject(
    randomRange: Rect = Rect(0f, 0f, 1f, 1f),
    multipleX: Float,
    multipleY: Float,
    alpha: Float = 1f,
    radius: Dp
) : RandomObject(
    randomRange = randomRange,
    multipleX = multipleX,
    multipleY = multipleY,
    size = radius,
    alpha = alpha
) {

    companion object {
        fun randomCreate(range: Rect, radiusDpRange: IntRange, alphaPercentRange: IntRange): StarObject {
            val randomPoint = randomPoint(range)
            return StarObject(
                range, randomPoint.x, randomPoint.y,
                alphaPercentRange.random() / 100f,
                radiusDpRange.random().dp
            )
        }
    }
}

@Preview(name = "MoonClearDarkTheme")
@Composable
fun MoonBackgroundPreview() {
    Surface(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            MoonBackground(Modifier.fillMaxSize())
        }
    }
}
