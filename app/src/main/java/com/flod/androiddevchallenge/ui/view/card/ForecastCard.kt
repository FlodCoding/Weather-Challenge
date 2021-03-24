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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flod.androiddevchallenge.R
import com.flod.androiddevchallenge.data.FakeWeatherRepository
import com.flod.androiddevchallenge.model.Simple
import com.flod.androiddevchallenge.ui.theme.MyThemedPreview
import com.flod.androiddevchallenge.ui.theme.cardBackgroundColor

@Composable
fun ForecastCard(list: List<Simple>) {
    val title = stringResource(id = R.string.card_title_future_forecast)
    Card(
        modifier = Modifier
            .padding(top = 10.dp)
            .semantics {
                contentDescription = title
            },
        backgroundColor = MaterialTheme.colors.cardBackgroundColor,
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 15.dp)
                .background(color = Color.Transparent)
        ) {
            Text(
                text = title,
                Modifier
                    .padding(horizontal = 10.dp)
                    .clearAndSetSemantics { },
                style = MaterialTheme.typography.subtitle2
            )
            LazyRow {
                itemsIndexed(list) { index, item ->
                    val weekEEE = if (index == 0) stringResource(R.string.today) else item.getWeekEEE()
                    val itemSetSemantics = "$weekEEE ${
                        stringResource(
                            R.string.low_high_temp,
                            item.temperature.min.toString(),
                            item.temperature.min.toString()
                        )
                    }, ${stringResource(item.mapWeatherIconRes())}"
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .semantics(true) { contentDescription = itemSetSemantics },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(text = weekEEE, style = MaterialTheme.typography.body2)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = item.getDateMMdd(), fontSize = 10.sp)
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "${item.temperature.min}°/${item.temperature.max}°",
                            style = MaterialTheme.typography.body2
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Image(
                            painter = painterResource(item.mapWeatherIconRes()),
                            modifier = Modifier.size(30.dp), contentDescription = null,
                        )

                        Text(text = item.type.name, fontSize = 10.sp)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ForecastCardLightPreview() {
    val repository = FakeWeatherRepository()

    MyThemedPreview {
        ForecastCard(repository.getLocationWeather(1).futureDayForecast)
    }
}


@Preview
@Composable
fun ForecastCardDarkPreview() {
    val repository = FakeWeatherRepository()
    MyThemedPreview(true) {
        ForecastCard(repository.getLocationWeather(1).futureDayForecast)
    }
}
