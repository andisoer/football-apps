package com.soerjdev.footballapps.ui.searchteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.soerjdev.footballapps.databinding.ActivitySearchTeamBinding
import com.soerjdev.footballapps.utils.ResourceStatus

class SearchTeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchTeamBinding
    private lateinit var viewModel: SearchTeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
        initViewModel()
        initObserver()
    }

    private fun initUi() {
        binding.apply {
            viewModel.searchTeam(teamName = "")
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[SearchTeamViewModel::class.java]
    }

    private fun initObserver() {
        viewModel.searchedTeam.observe(this, { dataStatus ->
            when (dataStatus) {
                is ResourceStatus.Loading ->  {

                }
                is ResourceStatus.Success -> {

                }
                is ResourceStatus.Error -> {

                }

            }
        })
    }
}