package com.davidstudioz.hypechats.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginRequest(val email: String, val password: String)
data class RegisterRequest(val name: String, val email: String, val password: String)
data class AuthResponse(val success: Boolean, val message: String, val token: String? = null, val user: User? = null)

data class User(
    val id: String,
    val name: String,
    val email: String,
    val avatar: String? = null,
    @SerializedName("is_online")
    val isOnline: Boolean = false
) : Serializable

data class Chat(
    val id: String,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("participant_id")
    val participantId: String,
    @SerializedName("last_message")
    val lastMessage: String? = null,
    val participant: User? = null
) : Serializable

data class Message(
    val id: String? = null,
    @SerializedName("chat_id")
    val chatId: String,
    @SerializedName("sender_id")
    val senderId: String,
    val content: String,
    @SerializedName("message_type")
    val messageType: String = "text",
    @SerializedName("media_url")
    val mediaUrl: String? = null,
    @SerializedName("created_at")
    val createdAt: String? = null
) : Serializable

data class FaceFilter(
    val id: String,
    val name: String,
    val image: String,
    val url: String,
    val type: String
) : Serializable