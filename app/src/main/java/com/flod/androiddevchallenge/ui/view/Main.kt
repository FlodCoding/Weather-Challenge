package com.flod.androiddevchallenge.ui.view

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flod.androiddevchallenge.MainViewModel
import com.flod.androiddevchallenge.R
import com.flod.androiddevchallenge.model.Detail
import com.flod.androiddevchallenge.model.Simple
import com.flod.androiddevchallenge.ui.theme.MyThemedPreview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Main(viewModel: MainViewModel) {

    val detail: Detail? by viewModel.detail.observeAsState()
    val locationList: List<Simple> by viewModel.locationList.observeAsState(emptyList())
    val locationSelected: Int by viewModel.locationSelected.observeAsState(0)

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()


    val scrollState = rememberScrollState()
    ModalDrawer(
        drawerBackgroundColor = MaterialTheme.colors.background,
        drawerState = drawerState,
        drawerContent = {
            LocationList(list = locationList, selected = locationSelected) { index, data ->
                viewModel.selectLocation(index, data)
                coroutineScope.launch {
                    drawerState.close()
                }
            }
        },
    ) {
        val data = detail ?: Detail.Undefined

        WeatherBackground(data.type)
        Box {
            Title(
                Modifier
                    .padding(top = 40.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                data,
                coroutineScope,
                drawerState
            )

            Header(data, scrollState.value)

            Body(data, scrollState)


        }
    }


}

private val BodyPadding = 260.dp
private val HeaderPadding = 120.dp
private val titleSpacing = 100.dp

@Composable
fun Title(modifier: Modifier, detail: Detail, coroutineScope: CoroutineScope, drawerState: DrawerState) {

    Box(modifier = modifier) {
        // drawer open button
        IconButton(
            modifier = Modifier.align(Alignment.CenterStart),
            onClick = {
                coroutineScope.launch {
                    drawerState.open()
                }
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_list),
                contentDescription = stringResource(id = R.string.select_location)
            )
        }


        //Top location name
        val currentLocationDesc = "${stringResource(R.string.current_location)} ${detail.locationName}," +
                if (detail.isMyLocation) stringResource(R.string.is_my_location) else ""
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .semantics(mergeDescendants = true) {
                    contentDescription = currentLocationDesc
                },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (detail.isMyLocation) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_location),
                    modifier = Modifier.size(20.dp), contentDescription = null
                )
            }

            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = detail.locationName,
                style = MaterialTheme.typography.h6
            )
        }

    }


}

@Composable
fun Header(detail: Detail, scroll: Int) {

    val range = with(LocalDensity.current) { (BodyPadding - HeaderPadding).toPx() }
    val alpha = 1 - (scroll / range).coerceAtMost(1f)


    Column(
        Modifier
            .padding(start = 30.dp)
            .alpha(alpha)
            .graphicsLayer {
                translationY = -scroll.toFloat()
            }) {

        Spacer(modifier = Modifier.height(HeaderPadding))
        Text(
            text = "${detail.temperature.current}°",
            style = MaterialTheme.typography.h1
        )
        Text(text = detail.type.name, fontSize = 30.sp, style = MaterialTheme.typography.h4)

        Row(Modifier.padding(horizontal = 10.dp, vertical = 20.dp)) {

            //Wind Speed and direction
            val windDesc = stringResource(R.string.wind_direction_and_speed, detail.wind.direction, detail.wind.speed)
            Column(
                modifier = Modifier
                    .weight(1f, true)
                    .semantics { contentDescription = windDesc },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "${detail.wind.direction} ${detail.wind.speed} ")
                Text(text = stringResource(id = R.string.wind), style = MaterialTheme.typography.caption)
            }

            //Air Quality Index
            val aqiDesc = "${stringResource(id = R.string.aqi_full_name)}: ${detail.aqi.value},${{ detail.aqi.desc }}"
            Column(
                modifier = Modifier
                    .weight(1f, true)
                    .semantics(true) { contentDescription = aqiDesc },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = detail.aqi.value.toString())
                Text(text = stringResource(id = R.string.aqi), style = MaterialTheme.typography.caption)
            }


            //Humidity percent
            val humidityDesc = "${stringResource(id = R.string.humidity)}: ${detail.humidity}"
            Column(
                modifier = Modifier
                    .weight(1f, true)
                    .semantics(true) { contentDescription = humidityDesc },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = detail.humidity)
                Text(text = stringResource(id = R.string.humidity), style = MaterialTheme.typography.caption)
            }


        }
    }


}

@Composable
fun Body(detail: Detail, scrollState: ScrollState) {

    Column(
        Modifier
            .padding(start = 15.dp, end = 15.dp, top = titleSpacing)
            .verticalScroll(scrollState)
    ) {

        Spacer(modifier = Modifier.padding(top = BodyPadding))

        HourlyForecastCard(temp = detail.temperature, list = detail.hourlyForecast)

        ForecastCard(list = detail.futureDayForecast)

        OthersCard(detail = detail)
    }


}

@Preview
@Composable
fun MainLightPreview() {
    MyThemedPreview {
        Main(viewModel = MainViewModel())
    }
}

@Preview
@Composable
fun MainDarkPreview() {
    MyThemedPreview(true) {
        Main(viewModel = MainViewModel())
    }
}

