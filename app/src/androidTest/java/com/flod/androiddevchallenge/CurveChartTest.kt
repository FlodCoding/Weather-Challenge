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
package com.flod.androiddevchallenge

import androidx.compose.ui.test.junit4.createComposeRule
import com.flod.androiddevchallenge.ui.component.TemperatureChart
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

class CurveChartTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    @Ignore("Can not find Canvas content")
    fun loadData() {

        val list = List(50) {
            Pair(it.toString(), (10..50).random())
        }
        composeTestRule.setContent {
            TemperatureChart(list = list)
        }
    }
}
