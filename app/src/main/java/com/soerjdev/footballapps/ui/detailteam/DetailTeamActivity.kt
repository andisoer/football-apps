package com.soerjdev.footballapps.ui.detailteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.soerjdev.footballapps.databinding.ActivityDetailTeamBinding

class DetailTeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTeamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}