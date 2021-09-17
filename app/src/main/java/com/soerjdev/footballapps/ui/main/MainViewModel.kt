package com.soerjdev.footballapps.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soerjdev.footballapps.data.model.League
import com.soerjdev.footballapps.data.repository.LeagueRepository
import com.soerjdev.footballapps.utils.ResourceStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {

    private val leagueRepository = LeagueRepository()

    private val _searchedLeague = MutableLiveData<ResourceStatus<League>>()

    val searchedLeague: LiveData<ResourceStatus<League>> get() = _searchedLeague

    fun searchLeague(
        sport: String,
        country: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            _searchedLeague.postValue(
                ResourceStatus.Loading()
            )

            try {

                val response = leagueRepository.searchLeague(
                    country = country,
                    sport = sport
                )

                if (response.isSuccessful) {
                    val league = response.body()

                    _searchedLeague.postValue(
                        ResourceStatus.Success(data = league)
                    )
                } else {
                    _searchedLeague.postValue(
                        ResourceStatus.Error(message = "Failed to search league")
                    )
                }

            } catch (exception: Exception) {
                _searchedLeague.postValue(
                    ResourceStatus.Error(message = exception.message)
                )
            }
        }
    }

}