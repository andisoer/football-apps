package com.soerjdev.footballapps.ui.choosesport

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.soerjdev.footballapps.R
import com.soerjdev.footballapps.data.model.Sport
import com.soerjdev.footballapps.databinding.ItemSportBinding

class ChooseSportAdapter(
    private val context: Context,
    private val onClick: (Sport.Sport) -> Unit
) : RecyclerView.Adapter<ChooseSportAdapter.ViewHolder>() {

    private val sportList = mutableListOf<Sport.Sport>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ItemSportBinding.inflate(inflater, parent, false)
        return ViewHolder(binding).apply {
            binding.root.setOnClickListener {
                onClick(getItem(adapterPosition))
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sportList[position])
    }

    override fun getItemCount() = sportList.size

    class ViewHolder(private val binding: ItemSportBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Sport.Sport) {
            item.strSportThumb?.let {
                binding.imageViewSport.load(
                    it
                ) {
                    crossfade(true)
                }
            }

            binding.textViewSportName.text = item.strSport
        }
    }

    fun setSportList(list: List<Sport.Sport>) {
        this.sportList.addAll(list)
        notifyDataSetChanged()
    }

    private fun getItem(position: Int) : Sport.Sport {
        return sportList[position]
    }
}
