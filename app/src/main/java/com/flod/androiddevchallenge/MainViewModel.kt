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
