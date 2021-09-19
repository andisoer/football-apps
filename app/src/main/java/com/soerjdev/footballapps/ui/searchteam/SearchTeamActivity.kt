package com.soerjdev.footballapps.ui.searchteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.soerjdev.footballapps.databinding.ActivitySearchTeamBinding
import com.soerjdev.footballapps.ui.detailteam.DetailTeamActivity
import com.soerjdev.footballapps.utils.ResourceStatus
import com.soerjdev.footballapps.utils.gone
import com.soerjdev.footballapps.utils.hideKeyboard
import com.soerjdev.footballapps.utils.show

class SearchTeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchTeamBinding
    private lateinit var searchTeamAdapter: SearchTeamRecyclerAdapter

    private lateinit var viewModel: SearchTeamViewModel

    private var league: String? = null

    companion object {
        var LEAGUE_NAME_KEY = "leagueName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
        initViewModel()
        initObserver()
        if (league != null) {
            searchTeamByLeague()
        }
    }

    private fun initUi() {

        val extras = intent.extras
        if (extras != null) {
            league = extras.getString(LEAGUE_NAME_KEY, null)
        }

        searchTeamAdapter = SearchTeamRecyclerAdapter(context = this) {team ->
            val intent = Intent(this, DetailTeamActivity::class.java)
            intent.putExtra(DetailTeamActivity.DETAIL_TEAM_KEY, team)
            startActivity(intent)
        }

        binding.apply {

            if (league == null) {
                textInputLayoutSearchTeam.show()
            }

            editTextSearchTeam.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    searchTeam()
                    return@setOnEditorActionListener true
                }
                return@setOnEditorActionListener false
            }

            toolbarSearchTeam.setNavigationOnClickListener {
                onBackPressed()
            }

            recyclerViewSearchTeam.adapter = searchTeamAdapter
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[SearchTeamViewModel::class.java]
    }

    private fun initObserver() {
        viewModel.searchedTeam.observe(this, { response ->
            when (response) {
                is ResourceStatus.Loading -> {
                    searchTeamAdapter.clearTeamList()
                    binding.progressBarSearchTeam.show()
                }
                is ResourceStatus.Success -> {
                    response.data?.let {
                        if (!it.teams.isNullOrEmpty())
                            searchTeamAdapter.setTeamList(it.teams)

                        binding.progressBarSearchTeam.gone()
                    }
                }
                is ResourceStatus.Error -> {
                    Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
                    binding.progressBarSearchTeam.gone()
                }

            }
        })
    }

    private fun searchTeam() {
        val teamName = binding.editTextSearchTeam.text.toString().trim()
        if (teamName.isEmpty()) return

        hideKeyboard()
        viewModel.searchTeam(teamName = teamName)
    }

    private fun searchTeamByLeague() {
        viewModel.searchTeamByLeague(league = league!!)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}