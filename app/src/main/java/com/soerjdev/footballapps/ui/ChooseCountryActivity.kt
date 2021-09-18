package com.soerjdev.footballapps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.soerjdev.footballapps.databinding.ActivityChooseCountryBinding

class ChooseCountryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseCountryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
    }

    private fun initUi() {
//        TODO("Not yet implemented")
    }
}