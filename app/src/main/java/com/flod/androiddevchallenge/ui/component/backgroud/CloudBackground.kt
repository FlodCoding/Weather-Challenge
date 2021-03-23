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
fun CloudBackground(
    modifier: Modifier,
    color: Color = Color(0xFFA5E4FF)
) {

    val fraction by rememberInfiniteTransition().animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            repeatMode = RepeatMode.Reverse,
            animation = tween(
                durationMillis = 10000,
                easing = LinearEasing
            ),
        )
    )


    Canvas(modifier = modifier.fillMaxSize()) {
        val width = size.width
        val radius = width * 0.7f
        val center = Offset(width, -density * 100)

        drawCircle(color, radius, center)
        drawCircle(
            color.copy(alpha = 0.4f), radius - fraction * 80, center.copy(y = -30 * density)
        )
        drawCircle(
            color.copy(alpha = 0.4f), radius + fraction * 100, center.copy(center.x - 50 * density)
        )


        drawCircle(color.copy(alpha = 0.2f), radius * 1.3f + fraction * 50, center)
    }
}


@Preview
@Composable
fun OvercastBackgroundPreview() {
    CloudBackground(Modifier.fillMaxSize())
}