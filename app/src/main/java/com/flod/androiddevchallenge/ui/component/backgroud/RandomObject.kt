@file:Suppress("MemberVisibilityCanBePrivate")

package com.flod.androiddevchallenge.ui.component.backgroud

import android.graphics.PointF
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.unit.Dp
import kotlin.math.cos
import kotlin.math.sin

open class RandomObject(
    val randomRange: Rect = Rect(0f, 0f, 1f, 1f),
    val fallRangeMultiple: Float = 1f,
    var multipleX: Float,
    var multipleY: Float,
    val alpha: Float = 1f,
    val size: Dp,
    val radian: Float = 1.3f,
    val speed: Int = 1,
) {

    companion object {
        fun randomPoint(range: Rect): PointF {
            val x = ((range.left * 1000).toInt()..(range.right * 1000).toInt()).random() / 1000f
            val y = ((range.top * 1000).toInt()..(range.bottom * 1000).toInt()).random() / 1000f
            return PointF(x, y)
        }
    }


    fun fadeIfAlmostGround(): Float {

        val left = fallRangeMultiple - multipleY
        return if (left < 0.1f) {
            (left / 0.1f) * alpha
        } else alpha
    }


    /**
     *   true: fall floor
     */
    fun fall(): Boolean {
        val inc = size.value * 0.00002f * speed
        multipleX -= cos(radian) * inc
        multipleY += sin(radian) * inc


        return multipleY / fallRangeMultiple >= 1
    }


    fun randomFormTop() {
        val point = randomPoint(randomRange)
        val cot = cos(radian) * sin(radian)
        multipleX = point.x + cot * point.y
        multipleY = 0f
    }
}