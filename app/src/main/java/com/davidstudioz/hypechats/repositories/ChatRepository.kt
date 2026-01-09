package com.davidstudioz.hypechats.repositories

import com.davidstudioz.hypechats.api.ApiClient
import com.davidstudioz.hypechats.api.ApiService
import com.davidstudioz.hypechats.models.Chat
import com.davidstudioz.hypechats.models.Message

class ChatRepository {
    private val apiService = ApiClient.createService(ApiService::class.java)

    suspend fun getConversations(): List<Chat> {
        val response = apiService.getConversations()
        return if (response.isSuccessful) response.body() ?: emptyList() else emptyList()
    }

    suspend fun getMessages(chatId: String): List<Message> {
        val response = apiService.getMessages(chatId)
        return if (response.isSuccessful) response.body() ?: emptyList() else emptyList()
    }

    suspend fun sendMessage(message: Message): Message? {
        val response = apiService.sendMessage(message)
        return if (response.isSuccessful) response.body() else null
    }
}