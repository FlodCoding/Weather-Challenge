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

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.flod.androiddevchallenge.ui.theme.MyThemedPreview

@Composable
fun CloudyMoonBackground(
    modifier: Modifier,
    moonColor: Color = Color(0x6DEBEBD5),
    cloudColor: Color = Color(0x41DBF3FD)
) {

    CloudBackground(modifier = modifier, color = cloudColor)

    MoonBackground(modifier = modifier, moonColor = moonColor, showStar = false)
}


@Preview
@Composable
fun CloudyMoonDarkPreview() {
    MyThemedPreview(true) {
        CloudyMoonBackground(Modifier.fillMaxSize())
    }

}
