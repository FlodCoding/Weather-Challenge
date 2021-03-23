@file:Suppress("DEPRECATION", "SpellCheckingInspection")

package com.flod.androiddevchallenge.data


import com.flod.androiddevchallenge.model.AQI
import com.flod.androiddevchallenge.model.Detail
import com.flod.androiddevchallenge.model.Simple
import com.flod.androiddevchallenge.model.Temperature
import com.flod.androiddevchallenge.model.WeatherType
import com.flod.androiddevchallenge.model.Wind
import java.util.*

val loctionList: List<Simple> = listOf(
    Simple(
        id = 1,
        locationName = "Fu Jian",
        date = Date(),
        type = WeatherType.Overcast,
        temperature = Temperature(11)
    ),
    Simple(
        id = 2,
        locationName = "Bei Jing",
        date = Date(),
        type = WeatherType.Sunny,
        temperature = Temperature(21)
    ),

    Simple(
        id = 3,
        locationName = "Shang Hai",
        date = Date(),
        type = WeatherType.Cloudy,
        temperature = Temperature(16)
    ),

    Simple(
        id = 4,
        locationName = "Hong Kong",
        date = Date(),
        type = WeatherType.Rain,
        temperature = Temperature(18)
    ),

    Simple(
        id = 5,
        locationName = "Moscow",
        date = Date(),
        type = WeatherType.Snow,
        temperature = Temperature(-3)
    ),

    )


val fuzhouDetail = Detail(
    id = 1,
    locationName = "Fu Zhou",
    type = WeatherType.Overcast,
    temperature = Temperature(
        current = 23,
        min = 18,
        max = 26
    ),
    wind = Wind(
        speed = "3 m/s",
        direction = "ESE"
    ),
    aqi = AQI(74, "Good"),
    humidity = "66%",
    pressure = "1026 hPa",
    visibility = "14.5 km",
    uvIndex = "0",
    precipitation = "0 mm",
    isMyLocation = true,
    futureDayForecast = listOf(
        Simple(
            locationName = "Fu Zhou",
            date = Date(2021, 2, 22),
            type = WeatherType.Overcast,
            temperature = Temperature(
                min = 9,
                max = 15
            )
        ),
        Simple(
            locationName = "Fu Zhou",
            date = Date(2021, 2, 23),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 11,
                max = 18
            )
        ),
        Simple(
            locationName = "Fu Zhou",
            date = Date(2021, 2, 24),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 13,
                max = 24
            )
        ),
        Simple(
            locationName = "Fu Zhou",
            date = Date(2021, 2, 25),
            type = WeatherType.Sunny,
            temperature = Temperature(
                min = 1,
                max = 15
            )
        ),
        Simple(
            locationName = "Fu Zhou",
            date = Date(2021, 2, 26),
            type = WeatherType.Sunny,
            temperature = Temperature(
                min = 16,
                max = 26
            )
        ),
        Simple(
            locationName = "Fu Zhou",
            date = Date(2021, 2, 27),
            type = WeatherType.Sunny,
            temperature = Temperature(
                min = 29,
                max = 18
            )
        ),
        Simple(
            locationName = "Fu Zhou",
            date = Date(2021, 2, 28),
            type = WeatherType.Rain,
            temperature = Temperature(
                min = 30,
                max = 19
            )
        ),
        Simple(
            locationName = "Fu Zhou",
            date = Date(2021, 2, 29),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 30,
                max = 19
            )
        ),


        ),
    hourlyForecast = listOf(
        Pair("Now", 23f), Pair("12:00", 23f), Pair("13:00", 25f), Pair("14:00", 26f), Pair("15:00", 26f),
        Pair("16:00", 24f), Pair("17:00", 23f), Pair("18:00", 21f), Pair("19:00", 19f), Pair("20:00", 18f),
        Pair("21:00", 18f), Pair("22:00", 18f), Pair("23:00", 18f), Pair("00:00", 18f), Pair("01:00", 18f),
        Pair("02:00", 18f), Pair("03:00", 18f), Pair("04:00", 18f), Pair("05:00", 18f), Pair("06:00", 18f),
        Pair("07:00", 18f), Pair("08:00", 19f), Pair("09:00", 21f), Pair("10:00", 22f)
    )
)


val beijingDetail: Detail = Detail(
    id = 2,
    locationName = "Bei Jing",
    type = WeatherType.Sunny,
    temperature = Temperature(
        current = 18,
        min = 11,
        max = 22
    ),
    wind = Wind(
        speed = "5 m/s",
        direction = "SSW"
    ),
    aqi = AQI(81, "Good"),
    humidity = "15 %",
    pressure = "1015 hPa",
    visibility = "9.7 km",
    uvIndex = "1",
    precipitation = "0 mm",
    futureDayForecast = listOf(
        Simple(
            date = Date(2021, 2, 22),
            type = WeatherType.Sunny,
            temperature = Temperature(
                min = 10,
                max = 22
            )
        ),
        Simple(
            date = Date(2021, 2, 23),
            type = WeatherType.Sunny,
            temperature = Temperature(
                min = 6,
                max = 21
            )
        ),
        Simple(
            date = Date(2021, 2, 24),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 8,
                max = 22
            )
        ),
        Simple(
            date = Date(2021, 2, 25),
            type = WeatherType.Overcast,
            temperature = Temperature(
                min = 10,
                max = 18
            )
        ),
        Simple(
            date = Date(2021, 2, 26),
            type = WeatherType.Sunny,
            temperature = Temperature(
                min = 22,
                max = 9
            )
        ),
        Simple(
            date = Date(2021, 2, 27),
            type = WeatherType.Overcast,
            temperature = Temperature(
                min = 9,
                max = 18
            )
        ),
        Simple(
            date = Date(2021, 2, 28),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 8,
                max = 18
            )
        ),
        Simple(
            date = Date(2021, 2, 29),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 10,
                max = 18
            )
        ),
    ),
    hourlyForecast = listOf(
        Pair("Now", 18), Pair("12:00", 19), Pair("13:00", 19), Pair("14:00", 19), Pair("15:00", 22),
        Pair("16:00", 22), Pair("17:00", 22), Pair("18:00", 19), Pair("19:00", 17), Pair("20:00", 15),
        Pair("21:00", 14), Pair("22:00", 13), Pair("23:00", 12), Pair("00:00", 11), Pair("01:00", 11),
        Pair("02:00", 11), Pair("03:00", 11), Pair("04:00", 11), Pair("05:00", 12), Pair("06:00", 12),
        Pair("07:00", 12), Pair("08:00", 13), Pair("09:00", 14), Pair("10:00", 17)
    )
)


val shanghaiDetail: Detail = Detail(
    id = 3,
    locationName = "Shang Hai",
    type = WeatherType.Cloudy,
    temperature = Temperature(
        current = 16,
        min = 11,
        max = 17
    ),
    wind = Wind(
        speed = "6 m/s",
        direction = "SSE"
    ),
    aqi = AQI(62, "Good"),
    humidity = "28 %",
    pressure = "1015 hPa",
    visibility = "9.7 km",
    uvIndex = "2",
    precipitation = "0 mm",
    futureDayForecast = listOf(
        Simple(
            date = Date(2021, 2, 22),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 8,
                max = 18
            )
        ),
        Simple(
            date = Date(2021, 2, 23),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 9,
                max = 18
            )
        ),
        Simple(
            date = Date(2021, 2, 24),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 14,
                max = 19
            )
        ),
        Simple(
            date = Date(2021, 2, 25),
            type = WeatherType.Rain,
            temperature = Temperature(
                min = 15,
                max = 22
            )
        ),
        Simple(
            date = Date(2021, 2, 26),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 12,
                max = 23
            )
        ),
        Simple(
            date = Date(2021, 2, 27),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 14,
                max = 21
            )
        ),
        Simple(
            date = Date(2021, 2, 28),
            type = WeatherType.Rain,
            temperature = Temperature(
                min = 13,
                max = 21
            )
        ),
        Simple(
            date = Date(2021, 2, 29),
            type = WeatherType.Rain,
            temperature = Temperature(
                min = 13,
                max = 17
            )
        ),
    ),
    hourlyForecast = listOf(
        Pair("Now", 16), Pair("12:00", 17), Pair("13:00", 17), Pair("14:00", 17), Pair("15:00", 17),
        Pair("16:00", 16), Pair("17:00", 15), Pair("18:00", 13), Pair("19:00", 12), Pair("20:00", 12),
        Pair("21:00", 12), Pair("22:00", 12), Pair("23:00", 12), Pair("00:00", 12), Pair("01:00", 12),
        Pair("02:00", 12), Pair("03:00", 12), Pair("04:00", 11), Pair("05:00", 11), Pair("06:00", 11),
        Pair("07:00", 12), Pair("08:00", 13), Pair("09:00", 14), Pair("10:00", 15)
    )
)

val hongkongDetail: Detail = Detail(
    id = 4,
    locationName = "Hong Kong",
    type = WeatherType.Rain,
    temperature = Temperature(
        current = 19,
        min = 11,
        max = 21
    ),
    wind = Wind(
        speed = "3 m/s",
        direction = "SE"
    ),
    aqi = AQI(62, "Good"),
    humidity = "75 %",
    pressure = "1020 hPa",
    visibility = "12.7 km",
    uvIndex = "2",
    precipitation = "10 mm",
    futureDayForecast = listOf(
        Simple(
            date = Date(2021, 2, 22),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 8,
                max = 22
            )
        ),
        Simple(
            date = Date(2021, 2, 23),
            type = WeatherType.Sunny,
            temperature = Temperature(
                min = 9,
                max = 24
            )
        ),
        Simple(
            date = Date(2021, 2, 24),
            type = WeatherType.Sunny,
            temperature = Temperature(
                min = 12,
                max = 24
            )
        ),
        Simple(
            date = Date(2021, 2, 25),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 15,
                max = 27
            )
        ),
        Simple(
            date = Date(2021, 2, 26),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 18,
                max = 29
            )
        ),
        Simple(
            date = Date(2021, 2, 27),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 18,
                max = 29
            )
        ),
        Simple(
            date = Date(2021, 2, 28),
            type = WeatherType.Rain,
            temperature = Temperature(
                min = 18,
                max = 29
            )
        ),
        Simple(
            date = Date(2021, 2, 29),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 17,
                max = 28
            )
        ),
    ),
    hourlyForecast = listOf(
        Pair("Now", 19), Pair("12:00", 20), Pair("13:00", 21), Pair("14:00", 21), Pair("15:00", 13),
        Pair("16:00", 13), Pair("17:00", 13), Pair("18:00", 12), Pair("19:00", 11), Pair("20:00", 11),
        Pair("21:00", 11), Pair("22:00", 11), Pair("23:00", 11), Pair("00:00", 11), Pair("01:00", 11),
        Pair("02:00", 11), Pair("03:00", 11), Pair("04:00", 11), Pair("05:00", 11), Pair("06:00", 11),
        Pair("07:00", 11), Pair("08:00", 13), Pair("09:00", 15), Pair("10:00", 17)
    ),
)

val moscowDetail: Detail = Detail(
    id = 5,
    locationName = "Moscow",
    type = WeatherType.Snow,
    temperature = Temperature(
        current = -1,
        min = -1,
        max = -9
    ),
    wind = Wind(
        speed = "3 m/s",
        direction = "N"
    ),
    aqi = AQI(74, "Good"),
    humidity = "71 %",
    pressure = "1011 hPa",
    visibility = "9.7 km",
    uvIndex = "1",
    precipitation = "0 mm",
    futureDayForecast = listOf(
        Simple(
            date = Date(2021, 2, 22),
            type = WeatherType.Snow,
            temperature = Temperature(
                min = -9,
                max = -1
            )
        ),
        Simple(
            date = Date(2021, 2, 23),
            type = WeatherType.Sunny,
            temperature = Temperature(
                min = 3,
                max = -5
            )
        ),
        Simple(
            date = Date(2021, 2, 24),
            type = WeatherType.Sunny,
            temperature = Temperature(
                min = -1,
                max = 6
            )
        ),
        Simple(
            locationName = "Fu Zhou",
            date = Date(2021, 2, 25),
            type = WeatherType.Overcast,
            temperature = Temperature(
                min = 1,
                max = 5
            )
        ),
        Simple(
            locationName = "Fu Zhou",
            date = Date(2021, 2, 26),
            type = WeatherType.Overcast,
            temperature = Temperature(
                min = -2,
                max = 4
            )
        ),
        Simple(
            locationName = "Fu Zhou",
            date = Date(2021, 2, 27),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = -1,
                max = 4
            )
        ),
        Simple(
            locationName = "Fu Zhou",
            date = Date(2021, 2, 28),
            type = WeatherType.Cloudy,
            temperature = Temperature(
                min = 1,
                max = 6
            )
        ),
        Simple(
            locationName = "Fu Zhou",
            date = Date(2021, 2, 29),
            type = WeatherType.Snow,
            temperature = Temperature(
                min = 1,
                max = 7
            )
        ),
    ),
    hourlyForecast = listOf(
        Pair("Now", 23f), Pair("12:00", 23f), Pair("13:00", 25f), Pair("14:00", 26f), Pair("15:00", 26f),
        Pair("16:00", 24f), Pair("17:00", 23f), Pair("18:00", 21f), Pair("19:00", 19f), Pair("20:00", 18f),
        Pair("21:00", 18f), Pair("22:00", 18f), Pair("23:00", 18f), Pair("00:00", 18f), Pair("01:00", 18f),
        Pair("02:00", 18f), Pair("03:00", 18f), Pair("04:00", 18f), Pair("05:00", 18f), Pair("06:00", 18f),
        Pair("07:00", 18f), Pair("08:00", 19f), Pair("09:00", 21f), Pair("10:00", 22f)
    )
)
