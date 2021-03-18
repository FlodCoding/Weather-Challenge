@file:Suppress("SpellCheckingInspection")

package com.flod.androiddevchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.flod.androiddevchallenge.data.FakeWeatherRepository
import com.flod.androiddevchallenge.model.Detail
import com.flod.androiddevchallenge.model.Simple


class MainViewModel : ViewModel() {
    private val _repository = FakeWeatherRepository()

    private val _detail = MutableLiveData(_repository.getLocationWeather(1))
    val detail: LiveData<Detail> = _detail

    private val _locationList = MutableLiveData(_repository.getLocationList())
    val locationList: LiveData<List<Simple>> = _locationList

    private val _locationSelected = MutableLiveData(0)
    val locationSelected: LiveData<Int> = _locationSelected

    fun selectLocation(index: Int, simple: Simple) {
        _locationSelected.value = index

        val detail = _repository.getLocationWeather(simple.id)
        _detail.value = detail

    }


}