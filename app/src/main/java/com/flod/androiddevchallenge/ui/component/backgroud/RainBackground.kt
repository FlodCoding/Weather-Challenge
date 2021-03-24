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
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.flod.androiddevchallenge.ui.theme.MyThemedPreview
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun RainBackground(
    modifier: Modifier,
    raindropNum: Int = 20,
    radian: Float = 1.3f,
    speed: Int = 1,
    rainColor: Color = Color(0xFF798DFF),
    cloudColor: Color = Color(0xFFD1D1D1),
) {

    val nearRainDropNum = (raindropNum * 0.2f).toInt()
    val list = List(raindropNum) {

        if (it < nearRainDropNum) {
            // create near raindrop, more big, closer top and right
            RainDrop.randomCreate(
                randomRange = Rect(left = 0.4f, right = 1f, top = 0.2f, bottom = 0.5f),
                heightMultiple = 0.5f,
                alphaPercentRange = 80..100,
                strokeWidthDpRange = 10..25,
                lengthDpRange = 50..100,
                radian = radian,
                speed = speed
            )
        } else {
            // create far raindrop, more small
            RainDrop.randomCreate(
                randomRange = Rect(-0.3f, 0.1f, 1f, 0.3f),
                heightMultiple = 0.5f,
                alphaPercentRange = 10..60,
                strokeWidthDpRange = 5..16,
                lengthDpRange = 50..100,
                radian = radian,
                speed = speed
            )
        }
    }

    Canvas(modifier = modifier.fillMaxSize()) {
        // draw rain drop
        list.forEach {
            val start = it.getStart(this)
            val end = it.getEnd(this)

            // if close to the ground, fade  drop
            val alpha = it.fadeIfAlmostGround()

            drawLine(
                color = rainColor.copy(alpha = alpha),
                strokeWidth = it.size.toPx(),
                start = start,
                end = end,
                cap = StrokeCap.Round
            )

            if (it.fall()) {
                it.randomFormTop()
            }
        }
    }

    CloudBackground(modifier = modifier.fillMaxSize(), color = cloudColor)
}

class RainDrop(
    randomRange: Rect = Rect(0f, 0f, 1f, 1f),
    heightMultiple: Float = 1f,
    multipleX: Float,
    multipleY: Float,
    alpha: Float = 1f,
    strokeWidth: Dp,
    radian: Float = 1.3f,
    speed: Int = 1,
    val length: Dp
) : RandomObject(randomRange, heightMultiple, multipleX, multipleY, alpha, strokeWidth, radian, speed) {

    companion object {
        fun randomCreate(
            randomRange: Rect,
            heightMultiple: Float,
            alphaPercentRange: IntRange,
            strokeWidthDpRange: IntRange,
            lengthDpRange: IntRange,
            radian: Float,
            speed: Int
        ): RainDrop {

            val randomPoint = randomPoint(randomRange)
            return RainDrop(
                randomRange = randomRange,
                heightMultiple = heightMultiple,
                multipleX = randomPoint.x,
                multipleY = randomPoint.y,
                alpha = alphaPercentRange.random() / 100f,
                strokeWidth = strokeWidthDpRange.random().dp,
                length = lengthDpRange.random().dp,
                radian = radian,
                speed = speed
            )
        }
    }

    fun getStart(scope: DrawScope): Offset {
        return Offset(multipleX * scope.size.width, multipleY * scope.size.height)
    }

    fun getEnd(scope: DrawScope): Offset {

        val length = scope.density * length.value
        return Offset(
            multipleX * scope.size.width + cos(radian) * length,
            multipleY * scope.size.height - sin(radian) * length,
        )
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
