package com.davidstudioz.hypechats.repositories

import com.davidstudioz.hypechats.api.ApiClient
import com.davidstudioz.hypechats.api.ApiService
import com.davidstudioz.hypechats.models.FaceFilter

class FilterRepository {
    private val apiService = ApiClient.createService(ApiService::class.java)

    suspend fun getFilters(): List<FaceFilter> {
        val response = apiService.getFilters()
        return if (response.isSuccessful) response.body() ?: emptyList() else emptyList()
    }
}