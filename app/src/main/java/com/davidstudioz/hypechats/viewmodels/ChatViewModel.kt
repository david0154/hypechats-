package com.davidstudioz.hypechats.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidstudioz.hypechats.models.Message
import com.davidstudioz.hypechats.repositories.ChatRepository
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    private val chatRepository = ChatRepository()
    
    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> = _messages
    
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading
    
    fun loadMessages(chatId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val messageList = chatRepository.getMessages(chatId)
                _messages.value = messageList
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun sendMessage(message: Message) {
        viewModelScope.launch {
            try {
                val sent = chatRepository.sendMessage(message)
                if (sent != null) {
                    val currentList = _messages.value?.toMutableList() ?: mutableListOf()
                    currentList.add(sent)
                    _messages.value = currentList
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}