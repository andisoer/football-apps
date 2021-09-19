package com.soerjdev.footballapps.ui.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.soerjdev.footballapps.databinding.ActivityMainBinding
import com.soerjdev.footballapps.ui.choosecountry.ChooseCountryActivity
import com.soerjdev.footballapps.ui.choosesport.ChooseSportActivity
import com.soerjdev.footballapps.ui.searchteam.SearchTeamActivity
import com.soerjdev.footballapps.utils.ResourceStatus
import com.soerjdev.footballapps.utils.gone
import com.soerjdev.footballapps.utils.show

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var searchLeagueAdapter: SearchLeagueAdapter

    private lateinit var viewModel: MainViewModel

    private var country = "Indonesia"
    private var sport = "Soccer"

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
                val intent = Intent(this@MainActivity, ChooseCountryActivity::class.java)
                intentChooseCountry.launch(intent)
            }

            buttonChooseSport.setOnClickListener {
                val intent = Intent(this@MainActivity, ChooseSportActivity::class.java)
                intentChooseSport.launch(intent)
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
        searchLeagueAdapter.clearLeagueList()
        viewModel.searchLeague(
            sport = sport,
            country = country
        )
    }

    private var intentChooseCountry = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val extras = result.data?.extras

            if (extras != null) {
                country = extras.getString(ChooseCountryActivity.CHOOSE_COUNTRY_KEY).toString()
                getLeague()
            }
        }
    }

    private var intentChooseSport = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val extras = result.data?.extras

            if (extras != null) {
                sport = extras.getString(ChooseSportActivity.CHOOSE_SPORT_KEY).toString()
                getLeague()
            }
        }
    }
}