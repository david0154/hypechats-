package com.davidstudioz.hypechats.repositories

import com.davidstudioz.hypechats.api.ApiClient
import com.davidstudioz.hypechats.api.ApiService
import com.davidstudioz.hypechats.database.ChatDatabase
import com.davidstudioz.hypechats.models.Chat
import com.davidstudioz.hypechats.models.Message
import android.content.Context

class ChatRepository(context: Context? = null) {
    
    private val apiService: ApiService = ApiClient.createService(ApiService::class.java)
    private val database = context?.let { ChatDatabase.getInstance(it) }
    
    suspend fun getChats(): List<Chat> {
        return try {
            val response = apiService.getConversations()
            if (response.isSuccessful) {
                response.body()?.data ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    suspend fun getMessages(chatId: String): List<Message> {
        return try {
            val response = apiService.getMessages(chatId)
            if (response.isSuccessful) {
                response.body()?.data ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    suspend fun sendMessage(chatId: String, message: String, imageUrl: String = "", latitude: Double = 0.0, longitude: Double = 0.0) {
        return try {
            apiService.sendMessage(
                chatId = chatId,
                text = message,
                imageUrl = imageUrl,
                latitude = latitude,
                longitude = longitude
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}