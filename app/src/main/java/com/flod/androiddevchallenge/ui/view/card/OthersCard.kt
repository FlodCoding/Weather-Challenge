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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.flod.androiddevchallenge.R
import com.flod.androiddevchallenge.model.Detail
import com.flod.androiddevchallenge.ui.theme.cardBackgroundColor

@Composable
fun OthersCard(detail: Detail) {

    val title = stringResource(id = R.string.card_title_others)
    Card(
        modifier = Modifier
            .padding(top = 10.dp, bottom = 60.dp)
            .fillMaxWidth(),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.cardBackgroundColor,
    ) {
        Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp)) {

            Text(text = title, style = MaterialTheme.typography.subtitle2, modifier = Modifier.clearAndSetSemantics { })

            Row(modifier = Modifier.padding(horizontal = 10.dp)) {
                // UV Index
                val uvIndexTitle = stringResource(id = R.string.uv_index)
                val uvIndexSemantics = "$uvIndexTitle: $detail.uvIndex"
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .semantics(true) {
                            contentDescription = uvIndexSemantics
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(

                        painter = painterResource(R.drawable.ic_uv),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )

                    Column(
                        modifier = Modifier
                            .padding(15.dp)
                            .clearAndSetSemantics { }
                    ) {
                        Text(text = uvIndexTitle, style = MaterialTheme.typography.body2)
                        Text(text = detail.uvIndex, modifier = Modifier.padding(top = 5.dp))
                    }
                }

                // precipitation
                val precipitationSemantics = "${stringResource(id = R.string.precipitation)}: ${detail.precipitation}"
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .semantics(true) { contentDescription = precipitationSemantics },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_precipitation),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )

                    Column(
                        modifier = Modifier
                            .padding(15.dp)
                            .clearAndSetSemantics { }
                    ) {
                        Text(text = stringResource(id = R.string.precipitation), style = MaterialTheme.typography.body2)
                        Text(text = detail.precipitation, modifier = Modifier.padding(top = 5.dp))
                    }
                }
            }

            // Visibility
            val visibilitySemantics = "${stringResource(id = R.string.visibility)}: detail.visibility"
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .semantics(true) { contentDescription = visibilitySemantics }
            ) {

                Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.ic_visibility),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )

                    Column(modifier = Modifier.padding(15.dp)) {
                        Text(text = stringResource(id = R.string.visibility), style = MaterialTheme.typography.body2)
                        Text(text = detail.visibility, modifier = Modifier.padding(top = 5.dp))
                    }
                }

                // Pressure
                val pressureSemantics = "${stringResource(id = R.string.pressure_full_name)}: ${detail.pressure}"
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .semantics(true) { contentDescription = pressureSemantics },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_pressure),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )

                    Column(modifier = Modifier.padding(15.dp)) {
                        Text(text = stringResource(R.string.pressure), style = MaterialTheme.typography.body2)
                        Text(text = detail.pressure, modifier = Modifier.padding(top = 5.dp))
                    }
                }
            }
        }
    }
}
