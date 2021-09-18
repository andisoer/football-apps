package com.soerjdev.footballapps.ui.choosecountry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.soerjdev.footballapps.databinding.ActivityChooseCountryBinding
import com.soerjdev.footballapps.utils.ResourceStatus

class ChooseCountryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseCountryBinding
    private lateinit var viewModel: ChooseCountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
        initViewModel()
        initObserver()
        getAllCountry()
    }

    private fun initUi() {
        binding.apply {

        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[ChooseCountryViewModel::class.java]
    }

    private fun initObserver() {
        viewModel.allCountry.observe(this, Observer { response ->
            when (response) {
                is ResourceStatus.Loading -> {

                }
                is ResourceStatus.Success -> {

                }
                is ResourceStatus.Error -> {

                }
            }
        })
    }

    private fun getAllCountry() {
        viewModel.allCountry()
    }
}