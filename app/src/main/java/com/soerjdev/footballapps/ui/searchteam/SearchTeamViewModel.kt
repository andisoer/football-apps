package com.soerjdev.footballapps.ui.searchteam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soerjdev.footballapps.data.model.Team
import com.soerjdev.footballapps.data.repository.TeamRepository
import com.soerjdev.footballapps.utils.ResourceStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchTeamViewModel : ViewModel() {

    private val teamRepository = TeamRepository()

    private val _searchedTeam = MutableLiveData<ResourceStatus<Team>>()

    val searchedTeam: LiveData<ResourceStatus<Team>> get() = _searchedTeam

    fun searchTeam(teamName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _searchedTeam.postValue(
                ResourceStatus.Loading()
            )

            try {

                val response = teamRepository.searchTeam(teamName = teamName)

                if (response.isSuccessful) {
                    val team = response.body()

                    _searchedTeam.postValue(
                        ResourceStatus.Success(data = team)
                    )
                } else {
                    _searchedTeam.postValue(
                        ResourceStatus.Error(message = "Failed to search team")
                    )
                }

            } catch (exception: Exception) {
                _searchedTeam.postValue(
                    ResourceStatus.Error(message = exception.message)
                )
            }
        }
    }

    fun searchTeamByLeague(league: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _searchedTeam.postValue(
                ResourceStatus.Loading()
            )

            try {

                val response = teamRepository.searchTeamByLeague(league = league)

                if (response.isSuccessful) {
                    val team = response.body()

                    _searchedTeam.postValue(
                        ResourceStatus.Success(data = team)
                    )
                } else {
                    _searchedTeam.postValue(
                        ResourceStatus.Error(message = "Failed to search team")
                    )
                }

            } catch (exception: Exception) {
                _searchedTeam.postValue(
                    ResourceStatus.Error(message = exception.message)
                )
            }
        }
    }
}