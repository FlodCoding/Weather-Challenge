package com.flod.androiddevchallenge.ui.component.backgroud

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CloudyMoonBackground(
    modifier: Modifier,
    moonColor: Color = Color(0x6DEBEBD5),
    cloudColor: Color = Color(0x41DBF3FD)
) {

    CloudBackground(modifier = modifier, color = cloudColor)

    MoonBackground(modifier = modifier, moonColor = moonColor,showStar = false)


}