package com.davidstudioz.hypechats.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.davidstudioz.hypechats.adapters.MessageAdapter
import com.davidstudioz.hypechats.databinding.ActivityChatDetailBinding
import com.davidstudioz.hypechats.viewmodels.ChatViewModel
import com.davidstudioz.hypechats.utils.Constants
import kotlinx.coroutines.*

class ChatDetailActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityChatDetailBinding
    private lateinit var viewModel: ChatViewModel
    private lateinit var messageAdapter: MessageAdapter
    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.Main + job)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        viewModel = ViewModelProvider(this).get(ChatViewModel::class.java)
        
        val chatId = intent.getStringExtra(Constants.CHAT_ID) ?: return
        val chatName = intent.getStringExtra(Constants.CHAT_NAME) ?: "Chat"
        
        setupUI(chatName)
        setupRecyclerView()
        observeMessages(chatId)
        setupSendButton(chatId)
    }

    private fun setupUI(chatName: String) {
        binding.apply {
            toolbar.title = chatName
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setupRecyclerView() {
        messageAdapter = MessageAdapter()
        binding.messagesRecycler.apply {
            layoutManager = LinearLayoutManager(this@ChatDetailActivity).apply {
                stackFromEnd = true
            }
            adapter = messageAdapter
        }
    }

    private fun observeMessages(chatId: String) {
        scope.launch {
            viewModel.loadMessages(chatId)
            viewModel.messages.observe(this@ChatDetailActivity) { messages ->
                messageAdapter.submitList(messages)
                binding.messagesRecycler.scrollToPosition(messages.size - 1)
            }
        }
    }

    private fun setupSendButton(chatId: String) {
        binding.sendBtn.setOnClickListener {
            val text = binding.messageInput.text.toString().trim()
            if (text.isNotEmpty()) {
                scope.launch {
                    viewModel.sendMessage(chatId, text)
                    binding.messageInput.text.clear()
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}