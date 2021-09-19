package com.soerjdev.footballapps.ui.choosecountry

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soerjdev.footballapps.data.model.Country
import com.soerjdev.footballapps.databinding.ItemCountryBinding

class ChooseCountryAdapter(
    private val context: Context,
    private val onClick: (Country.Country) -> Unit
) :
    RecyclerView.Adapter<ChooseCountryAdapter.ViewHolder>() {

    private val countryList = mutableListOf<Country.Country>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ItemCountryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding).apply {
            binding.root.setOnClickListener {
                onClick(getItem(position = adapterPosition))
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(countryList[position])
    }

    override fun getItemCount() = countryList.size

    class ViewHolder(private val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Country.Country) {
            binding.textViewCountryName.text = item.nameEn
        }
    }

    fun setCountryList(list: List<Country.Country>) {
        this.countryList.addAll(list)
        notifyDataSetChanged()
    }

    private fun getItem(position: Int) : Country.Country {
        return countryList[position]
    }

}