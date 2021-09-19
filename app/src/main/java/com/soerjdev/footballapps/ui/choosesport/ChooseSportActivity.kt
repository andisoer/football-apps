package com.soerjdev.footballapps.ui.choosesport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.soerjdev.footballapps.databinding.ActivityChooseSportBinding
import com.soerjdev.footballapps.utils.ResourceStatus
import com.soerjdev.footballapps.utils.gone
import com.soerjdev.footballapps.utils.show

class ChooseSportActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseSportBinding
    private lateinit var chooseSportAdapter: ChooseSportAdapter

    private lateinit var viewModel: ChooseSportViewModel

    companion object {
        var CHOOSE_SPORT_KEY = "chooseSport"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseSportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
        initViewModel()
        initObserver()
        getAllSport()
    }

    private fun initUi() {

        chooseSportAdapter = ChooseSportAdapter(context = this) { sport ->
            val resultIntent = intent
            resultIntent.putExtra(CHOOSE_SPORT_KEY, sport.strSport)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        binding.apply {
            toolbarChooseSport.setNavigationOnClickListener {
                onBackPressed()
            }

            recyclerViewChooseSport.adapter = chooseSportAdapter
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[ChooseSportViewModel::class.java]
    }

    private fun initObserver() {
        viewModel.allSport.observe(this, { response ->
            when (response) {
                is ResourceStatus.Loading -> {
                    binding.progressBarChooseSport.show()
                }
                is ResourceStatus.Success -> {
                    response.data?.let {
                        if (!it.sports.isNullOrEmpty()) {
                            chooseSportAdapter.setSportList(it.sports)
                        }
                    }

                    binding.progressBarChooseSport.gone()
                }
                is ResourceStatus.Error -> {
                    binding.progressBarChooseSport.gone()
                }
            }
        })
    }

    private fun getAllSport() {
        viewModel.allSport()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}