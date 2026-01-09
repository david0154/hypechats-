package com.davidstudioz.hypechats.api

import com.davidstudioz.hypechats.models.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<AuthResponse>

    @GET("user/profile")
    suspend fun getUserProfile(): Response<User>

    @GET("chat/conversations")
    suspend fun getConversations(): Response<List<Chat>>

    @POST("chat/send")
    suspend fun sendMessage(@Body message: Message): Response<Message>

    @GET("chat/{chatId}/messages")
    suspend fun getMessages(
        @Path("chatId") chatId: String,
        @Query("limit") limit: Int = 50
    ): Response<List<Message>>

    @GET("filters/list")
    suspend fun getFilters(): Response<List<FaceFilter>>
}