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
package com.flod.androiddevchallenge.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flod.androiddevchallenge.R
import com.flod.androiddevchallenge.data.FakeWeatherRepository
import com.flod.androiddevchallenge.model.Simple
import com.flod.androiddevchallenge.ui.theme.MyThemedPreview
import com.flod.androiddevchallenge.ui.theme.listSelectedColor

@Composable
fun LocationList(list: List<Simple>, selected: Int = 0, onSelected: (Int, Simple) -> Unit) {

    Column(
        modifier = Modifier
            .padding(top = 50.dp)
            .semantics { testTag = "LocationList" }
            .selectableGroup(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        list.forEachIndexed { index, data ->
            val desc = "${data.locationName} ${stringResource(data.mapWeatherTypeStringRes())} " +
                "${data.temperature.current}°"
            Row(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .background(if (selected == index) MaterialTheme.colors.listSelectedColor else MaterialTheme.colors.surface)
                    .semantics(true) { contentDescription = desc }
                    .selectable(index == selected) {
                        onSelected(index, data)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data.locationName,
                    modifier = Modifier.padding(start = 20.dp, top = 30.dp, end = 10.dp, bottom = 30.dp)
                )
                if (index == 0)
                    Image(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(R.drawable.ic_location),
                        contentDescription = data.type.name
                    )

                Spacer(modifier = Modifier.weight(1f))
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = data.mapWeatherIconRes()),
                    contentDescription = data.type.name
                )
                Text(
                    text = "${data.temperature.current}°",
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(start = 10.dp, top = 30.dp, end = 30.dp, bottom = 30.dp)
                        .width(30.dp)
                )
            }
        }

        Button(
            onClick = { },
            shape = CircleShape,
            modifier = Modifier
                .width(200.dp)
                .padding(top = 15.dp)
        ) {
            Text(text = stringResource(id = R.string.add))
        }
    }
}

@Preview
@Composable
fun LocationListLightPreview() {
    val repository = FakeWeatherRepository()
    MyThemedPreview {
        LocationList(repository.getLocationList()) { _, _ -> }
    }
}

@Preview
@Composable
fun LocationListDarkPreview() {
    val repository = FakeWeatherRepository()
    MyThemedPreview(true) {
        LocationList(repository.getLocationList()) { _, _ -> }
    }
}
