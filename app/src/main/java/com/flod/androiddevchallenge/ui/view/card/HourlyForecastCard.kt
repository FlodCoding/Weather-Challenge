package com.flod.androiddevchallenge.ui.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flod.androiddevchallenge.R
import com.flod.androiddevchallenge.model.Temperature
import com.flod.androiddevchallenge.ui.component.TemperatureChart
import com.flod.androiddevchallenge.ui.theme.cardBackgroundColor

@Composable
fun HourlyForecastCard(temp: Temperature, list: List<Pair<String, Number>>) {
    val title = stringResource(id = R.string.card_title_hourly_temp)
    Card(
        Modifier.semantics { contentDescription = title },
        backgroundColor = MaterialTheme.colors.cardBackgroundColor, elevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .height(200.dp)
                .padding(vertical = 15.dp)
        ) {
            val lowHighTempDesc = stringResource(R.string.low_high_temp, temp.min.toString(), temp.max.toString())
            Row(
                Modifier
                    .padding(horizontal = 10.dp)
                    .semantics { contentDescription = lowHighTempDesc }, verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.clearAndSetSemantics {})
                Spacer(Modifier.weight(1f))
                Text(text = "${temp.min}° / ${temp.max}°°", fontSize = 12.sp)
            }

            TemperatureChart(list = list)
        }


    }
}