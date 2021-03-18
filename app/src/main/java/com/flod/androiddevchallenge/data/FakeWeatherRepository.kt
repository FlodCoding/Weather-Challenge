@file:Suppress("SpellCheckingInspection", "DEPRECATION")

package com.flod.androiddevchallenge.data

import com.flod.androiddevchallenge.model.Detail
import com.flod.androiddevchallenge.model.Simple

class FakeWeatherRepository : WeatherRepository {

    private val _datails = ArrayList(datailList)

    private val _locations = ArrayList(loctionList)

    override fun getLocationWeather(id: Long): Detail {
        return _datails.find { it.id == id }!!
    }

    override fun getLocationList(): List<Simple> {
        return _locations
    }




}