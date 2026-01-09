package com.davidstudioz.hypechats.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidstudioz.hypechats.models.Chat
import com.davidstudioz.hypechats.repositories.ChatRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val chatRepository = ChatRepository()
    
    private val _conversations = MutableLiveData<List<Chat>>()
    val conversations: LiveData<List<Chat>> = _conversations
    
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading
    
    fun loadConversations() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val chats = chatRepository.getConversations()
                _conversations.value = chats
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}