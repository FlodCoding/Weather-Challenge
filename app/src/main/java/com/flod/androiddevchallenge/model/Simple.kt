package com.flod.androiddevchallenge.model

import com.flod.androiddevchallenge.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


data class Simple(
    val id: Long = -1,
    val locationName: String = "",
    val date: Date,
    val type: WeatherType,
    val temperature: Temperature,
) {

    fun getWeekEEE(): String {
        return SimpleDateFormat("EEE", Locale.getDefault()).format(date)
    }

    fun getDateMMdd(): String {
        return SimpleDateFormat("MM-dd", Locale.getDefault()).format(date)
    }


    fun mapWeatherIconRes(): Int {
        return when (type) {
            WeatherType.Sunny -> R.drawable.ic_sunny
            WeatherType.Cloudy -> R.drawable.ic_cloudy
            WeatherType.Overcast -> R.drawable.ic_overcast
            WeatherType.Rain -> R.drawable.ic_rain
            WeatherType.Snow -> R.drawable.ic_snow
            WeatherType.Undefined -> R.drawable.ic_unknow_weather
        }
    }

    fun mapWeatherTypeStringRes(): Int {
        return when (type) {
            WeatherType.Sunny -> R.string.weather_type_sunny
            WeatherType.Cloudy -> R.string.weather_type_cloud
            WeatherType.Overcast -> R.string.weather_type_overcast
            WeatherType.Rain -> R.string.weather_type_rain
            WeatherType.Snow -> R.string.weather_type_snow
            WeatherType.Undefined -> R.string.weather_type_unknown
        }

    }
}
