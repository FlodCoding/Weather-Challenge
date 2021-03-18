package com.flod.androiddevchallenge.data

import com.flod.androiddevchallenge.model.Detail
import com.flod.androiddevchallenge.model.Simple

interface WeatherRepository {

    fun getLocationWeather(id: Long): Detail

    fun getLocationList(): List<Simple>


}