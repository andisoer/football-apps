package com.soerjdev.footballapps.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.soerjdev.footballapps.databinding.ActivityMainBinding
import com.soerjdev.footballapps.ui.searchteam.SearchTeamActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
    }

    private fun initUi() {
        binding.buttonToSearch.setOnClickListener {
            startActivity(Intent(this, SearchTeamActivity::class.java))
        }
    }
}