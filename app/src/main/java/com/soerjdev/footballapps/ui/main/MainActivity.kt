package com.soerjdev.footballapps.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.soerjdev.footballapps.databinding.ActivityMainBinding
import com.soerjdev.footballapps.ui.ChooseCountryActivity
import com.soerjdev.footballapps.ui.searchteam.SearchTeamActivity
import com.soerjdev.footballapps.utils.ResourceStatus
import com.soerjdev.footballapps.utils.gone
import com.soerjdev.footballapps.utils.show

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var searchLeagueAdapter: SearchLeagueAdapter

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
        initViewModel()
        initObserver()
        getLeague()
    }

    private fun initUi() {

        searchLeagueAdapter = SearchLeagueAdapter(context = this)

        binding.apply {

            recyclerViewSearchLeague.adapter = searchLeagueAdapter

            buttonToSearch.setOnClickListener {
                startActivity(Intent(this@MainActivity, SearchTeamActivity::class.java))
            }

            buttonChooseCountry.setOnClickListener {
                startActivity(Intent(this@MainActivity, ChooseCountryActivity::class.java))
            }
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[MainViewModel::class.java]
    }

    private fun initObserver() {
        viewModel.searchedLeague.observe(this, { response ->
            when (response) {
                is ResourceStatus.Loading -> {
                    binding.progressBarSearchLeague.show()
                }
                is ResourceStatus.Success -> {
                    response.data?.let {
                        if (!it.countrys.isNullOrEmpty()) {
                            searchLeagueAdapter.setLeagueList(it.countrys)
                        }
                    }
                    binding.progressBarSearchLeague.gone()
                }
                is ResourceStatus.Error -> {
                    binding.progressBarSearchLeague.gone()
                }
            }
        })
    }

    private fun getLeague() {
        viewModel.searchLeague(
            sport = "Soccer",
            country = "Indonesia"
        )
    }
}