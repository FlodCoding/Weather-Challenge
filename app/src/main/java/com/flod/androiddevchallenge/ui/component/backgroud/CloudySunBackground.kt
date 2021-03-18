package com.flod.androiddevchallenge.ui.component.backgroud

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun CloudySunBackground(
    modifier: Modifier,
    sunColor: Color = Color(0x95F5CD58),
    cloudColor: Color = Color(0xFFA5E4FF)
) {

    CloudBackground(modifier = modifier, color = cloudColor)

    Canvas(modifier) {

        val canvasWidth = size.width

        //draw sun ☀️
        val sunRadius = canvasWidth * 0.25f
        val sunCenter = Offset(size.width * 0.95f, sunRadius * 0.3f)
        drawCircle(sunColor, sunRadius, sunCenter)

    }
}


@Preview
@Composable
fun CloudyBackgroundLightPreview() {
    CloudySunBackground(Modifier.fillMaxSize())
}

