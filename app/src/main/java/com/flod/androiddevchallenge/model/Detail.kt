package com.flod.androiddevchallenge.model


class Detail(
    val id: Long,
    val locationName: String = "",
    val isMyLocation: Boolean = false,
    val type: WeatherType = WeatherType.Undefined,
    val temperature: Temperature = Temperature(),
    val wind: Wind = Wind("", ""),
    val aqi: AQI = AQI(0, ""),
    val humidity: String,
    val pressure: String,
    val visibility: String,
    val uvIndex: String,
    val precipitation: String,
    val hourlyForecast: List<Pair<String, Number>> = emptyList(),
    val futureDayForecast: List<Simple> = emptyList(),

    ) {
    companion object {
        val Undefined = Detail(
            -1, "", false, WeatherType.Undefined,
            Temperature(),
            Wind("", ""),
            AQI(0, ""),
            "", "", "", "", ""
        )

    }
}


data class Temperature(
    val current: Number? = null,
    val min: Number? = null,
    val max: Number? = null,
)

data class Wind(
    val speed: String,
    val direction: String,
)

data class AQI(
    val value: Number,
    val desc: String
)


