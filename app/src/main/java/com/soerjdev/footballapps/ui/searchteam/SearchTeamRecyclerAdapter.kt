package com.soerjdev.footballapps.ui.searchteam

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soerjdev.footballapps.data.model.Team
import com.soerjdev.footballapps.databinding.ItemTeamBinding

class SearchTeamRecyclerAdapter(private val context: Context): RecyclerView.Adapter<SearchTeamRecyclerAdapter.ViewHolder>() {

    private val teamList = mutableListOf<Team.Team>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = ItemTeamBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(teamList[position])
    }

    override fun getItemCount() = teamList.size

    class ViewHolder(private val binding: ItemTeamBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(team: Team.Team) {
            binding.apply {
                textViewTeamName.text = team.strTeam
                textViewCountry.text = team.strCountry
                textViewLeague.text = team.strLeague
                textViewSport.text = team.strSport
            }
        }
    }

    fun setTeamList(list: List<Team.Team>) {
        this.teamList.addAll(list)
        notifyDataSetChanged()
    }

    fun clearTeamList() {
        this.teamList.clear()
        notifyDataSetChanged()
    }
}