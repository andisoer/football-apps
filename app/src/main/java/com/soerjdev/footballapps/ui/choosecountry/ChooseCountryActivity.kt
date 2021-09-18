package com.soerjdev.footballapps.ui.choosecountry

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.soerjdev.footballapps.data.model.Country
import com.soerjdev.footballapps.databinding.ActivityChooseCountryBinding
import com.soerjdev.footballapps.utils.ResourceStatus
import com.soerjdev.footballapps.utils.gone
import com.soerjdev.footballapps.utils.show

class ChooseCountryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseCountryBinding
    private lateinit var chooseCountryAdapter: ChooseCountryAdapter

    private lateinit var viewModel: ChooseCountryViewModel

    companion object {
        var CHOOSE_COUNTRY_KEY = "chooseCountry"
    }

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
        chooseCountryAdapter = ChooseCountryAdapter(context = this) { result ->
            val resultIntent = intent
            resultIntent.putExtra(CHOOSE_COUNTRY_KEY, result.nameEn)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        binding.apply {
            toolbarChooseCountry.setNavigationOnClickListener {
                onBackPressed()
            }

            val itemDivider =
                DividerItemDecoration(this@ChooseCountryActivity, DividerItemDecoration.VERTICAL)
            recyclerViewChooseCountry.addItemDecoration(itemDivider)
            recyclerViewChooseCountry.adapter = chooseCountryAdapter
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[ChooseCountryViewModel::class.java]
    }

    private fun initObserver() {
        viewModel.allCountry.observe(this, { response ->
            when (response) {
                is ResourceStatus.Loading -> {
                    binding.progressBarCHooseCountry.show()
                }
                is ResourceStatus.Success -> {
                    response.data?.let {
                        if (!it.countries.isNullOrEmpty()) {
                            chooseCountryAdapter.setCountryList(it.countries)
                        }
                    }
                    binding.progressBarCHooseCountry.gone()
                }
                is ResourceStatus.Error -> {
                    binding.progressBarCHooseCountry.gone()
                }
            }
        })
    }

    private fun getAllCountry() {
        viewModel.allCountry()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}