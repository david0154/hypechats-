package com.davidstudioz.hypechats.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.davidstudioz.hypechats.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupUI()
    }

    private fun setupUI() {
        // Setup main UI components
    }
}