package com.soerjdev.footballapps.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.soerjdev.footballapps.data.model.League
import com.soerjdev.footballapps.databinding.ItemLeagueBinding

class SearchLeagueAdapter(private val context: Context): RecyclerView.Adapter<SearchLeagueAdapter.ViewHolder>() {

    private val leagueList = mutableListOf<League.League>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ItemLeagueBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount() = leagueList.size

    class ViewHolder(private val binding: ItemLeagueBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: League.League) {
            binding.apply {
                imageViewLogo.load(
                    item.strLogo
                )

                textViewLeagueName.text = item.strLeague
                textViewCountry.text = item.strCountry
            }
        }
    }

    private fun getItem(position: Int): League.League {
        return leagueList[position]
    }

    fun setLeagueList(list: List<League.League>) {
        this.leagueList.addAll(list)
        notifyDataSetChanged()
    }

    fun clearLeagueList() {
        this.leagueList.clear()
        notifyDataSetChanged()
    }
}