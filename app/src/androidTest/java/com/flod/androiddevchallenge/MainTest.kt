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

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performGesture
import androidx.compose.ui.test.swipeLeft
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

class MainTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.launchApp()
    }

    @Test
    @Ignore("passes locally but fail on CI")
    fun testDrawer() {
        // Open it
        composeTestRule.onNodeWithContentDescription("select location")
            .assertIsDisplayed().performClick()

        composeTestRule.onNodeWithTag("LocationList").assertIsDisplayed()

        // close Drawer using Gesture
        composeTestRule.onNodeWithTag("LocationList").performGesture {
            swipeLeft()
        }
        composeTestRule.onNodeWithContentDescription("select location").assertIsDisplayed()
    }
}
