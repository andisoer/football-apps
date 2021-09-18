package com.soerjdev.footballapps.ui.choosecountry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soerjdev.footballapps.data.model.Country
import com.soerjdev.footballapps.data.repository.CountryRepository
import com.soerjdev.footballapps.utils.ResourceStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class ChooseCountryViewModel: ViewModel() {

    private val countryRepository = CountryRepository()

    private val _allCountry = MutableLiveData<ResourceStatus<Country>>()

    val allCountry: LiveData<ResourceStatus<Country>> get() = _allCountry

    fun allCountry() {
        viewModelScope.launch(Dispatchers.IO) {
            _allCountry.postValue(
                ResourceStatus.Loading()
            )

            try {

                val response = countryRepository.allCountry()

                if (response.isSuccessful) {
                    val country = response.body()

                    _allCountry.postValue(
                        ResourceStatus.Success(data = country)
                    )
                } else {
                    _allCountry.postValue(
                        ResourceStatus.Error(message = "Failed to fetch all country")
                    )
                }

            } catch (exception: Exception) {
                _allCountry.postValue(
                    ResourceStatus.Error(message = exception.message)
                )
            }
        }
    }

}