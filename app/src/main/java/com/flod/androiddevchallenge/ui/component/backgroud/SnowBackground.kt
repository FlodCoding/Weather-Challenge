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
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.flod.androiddevchallenge.ui.theme.MyThemedPreview

@Composable
fun SnowBackground(
    modifier: Modifier,
    raindropNum: Int = 20,
    radian: Float = 1.3f,
    speed: Int = 1,
    snowColor: Color = Color(0xFFFFFFFF),
    cloudColor: Color = Color(0xFFD1D1D1),
) {
    val nearRainDropNum = (raindropNum * 0.2f).toInt()

    val list = MutableList(raindropNum) {

        if (it < nearRainDropNum) {
            // create near snow, more big, closer top and right
            SnowDrop.randomCreate(
                randomRange = Rect(left = 0.4f, right = 1f, top = 0.2f, bottom = 0.5f),
                heightMultiple = 0.5f,
                alphaPercentRange = 80..100,
                radiusDpRange = 10..25,
                radian = radian,
                speed = speed
            )
        } else {
            // create far snow, more small
            SnowDrop.randomCreate(
                randomRange = Rect(-0.3f, 0.1f, 1f, 0.3f),
                heightMultiple = 0.5f,
                alphaPercentRange = 10..60,
                radiusDpRange = 5..16,
                radian = radian,
                speed = speed
            )
        }
    }

    Canvas(modifier = modifier.fillMaxSize()) {
        // draw snow
        list.forEach {
            val center = it.getCenter(this)

            // if close to the ground, fade  drop
            val alpha = it.fadeIfAlmostGround()

            drawCircle(
                color = snowColor.copy(alpha = alpha),
                radius = it.size.toPx(),
                center = center
            )

            if (it.fall()) {
                it.randomFormTop()
            }
        }
    }

    CloudBackground(modifier = modifier.fillMaxSize(), color = cloudColor)
}

class SnowDrop(
    randomRange: Rect = Rect(0f, 0f, 1f, 1f),
    heightMultiple: Float = 1f,
    multipleX: Float,
    multipleY: Float,
    alpha: Float = 1f,
    strokeWidth: Dp,
    radian: Float = 1.3f,
    speed: Int = 1
) : RandomObject(randomRange, heightMultiple, multipleX, multipleY, alpha, strokeWidth, radian, speed) {
    companion object {
        fun randomCreate(
            randomRange: Rect,
            heightMultiple: Float,
            alphaPercentRange: IntRange,
            radiusDpRange: IntRange,
            radian: Float,
            speed: Int
        ): SnowDrop {
            val randomPoint = randomPoint(randomRange)
            return SnowDrop(
                randomRange = randomRange,
                heightMultiple = heightMultiple,
                multipleX = randomPoint.x,
                multipleY = randomPoint.y,
                alpha = alphaPercentRange.random() / 100f,
                strokeWidth = radiusDpRange.random().dp,
                radian = radian,
                speed = speed
            )
        }
    }

    fun getCenter(scope: DrawScope) = Offset(multipleX * scope.size.width, multipleY * scope.size.height)
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
