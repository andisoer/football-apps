package com.soerjdev.footballapps.ui.detailteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.soerjdev.footballapps.data.model.Team
import com.soerjdev.footballapps.databinding.ActivityDetailTeamBinding

class DetailTeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTeamBinding

    private lateinit var team: Team.Team

    companion object {
        var DETAIL_TEAM_KEY = "detailTeam"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
    }

    private fun initUi() {

        val extras = intent.extras
        if (extras != null) {
            team = extras.getParcelable<Team.Team>(DETAIL_TEAM_KEY) as Team.Team
        }

        binding.toolbarDetailTeam.setNavigationOnClickListener {
            onBackPressed()
        }

        setData()
    }

    private fun setData() {
        binding.apply {
            imageViewTeamBanner.load(
                team.strTeamBadge
            )

            textViewTeamName.text = team.strTeam
            textViewFormedYear.text = team.intFormedYear
            textViewSport.text = team.strSport
            textViewCountry.text = team.strCountry

            textViewTeamDescription.text = team.strDescriptionEN

            imageViewStadiumThumbnail.load(
                team.strStadiumThumb
            )

            textViewStadiumName.text = team.strStadium
            textViewStadiumLocation.text = team.strStadiumLocation
            textViewStadiumCapacity.text = team.intStadiumCapacity
            textViewStadiumDescription.text = team.strStadiumDescription
        }
    }
}