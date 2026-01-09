package com.davidstudioz.hypechats.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.davidstudioz.hypechats.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupListeners()
    }

    private fun setupListeners() {
        // Setup login button listeners
    }
}