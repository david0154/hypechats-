package com.davidstudioz.hypechats.repositories

import com.davidstudioz.hypechats.api.ApiClient
import com.davidstudioz.hypechats.api.ApiService
import com.davidstudioz.hypechats.models.AuthResponse
import com.davidstudioz.hypechats.models.LoginRequest
import com.davidstudioz.hypechats.models.RegisterRequest
import com.davidstudioz.hypechats.models.User

class UserRepository {
    private val apiService = ApiClient.createService(ApiService::class.java)

    suspend fun login(email: String, password: String): AuthResponse? {
        val request = LoginRequest(email, password)
        val response = apiService.login(request)
        return if (response.isSuccessful) response.body() else null
    }

    suspend fun register(name: String, email: String, password: String): AuthResponse? {
        val request = RegisterRequest(name, email, password)
        val response = apiService.register(request)
        return if (response.isSuccessful) response.body() else null
    }

    suspend fun getUserProfile(): User? {
        val response = apiService.getUserProfile()
        return if (response.isSuccessful) response.body() else null
    }
}