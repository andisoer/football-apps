package com.soerjdev.footballapps.ui.choosesport

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soerjdev.footballapps.data.model.Sport
import com.soerjdev.footballapps.data.repository.SportRepository
import com.soerjdev.footballapps.utils.ResourceStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class ChooseSportViewModel: ViewModel() {

    private val sportRepository = SportRepository()

    private val _allSport = MutableLiveData<ResourceStatus<Sport>>()

    val allSport: LiveData<ResourceStatus<Sport>> get() = _allSport

    fun allSport() {
        viewModelScope.launch(Dispatchers.IO) {
            _allSport.postValue(
                ResourceStatus.Loading()
            )

            try {

                val response = sportRepository.allSport()

                if (response.isSuccessful) {
                    val sport = response.body()

                    _allSport.postValue(
                        ResourceStatus.Success(data = sport)
                    )
                } else {
                    _allSport.postValue(
                        ResourceStatus.Error(message = "Failed to fetch all sport")
                    )
                }

            } catch (exception: Exception) {
                _allSport.postValue(
                    ResourceStatus.Error(message = exception.message)
                )
            }
        }
    }

}