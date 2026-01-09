package com.davidstudioz.hypechats.database

import android.content.Context
import androidx.room.*
import com.davidstudioz.hypechats.models.Chat
import com.davidstudioz.hypechats.models.Message
import com.davidstudioz.hypechats.models.User

@Database(
    entities = [Chat::class, Message::class, User::class],
    version = 1,
    exportSchema = false
)
abstract class ChatDatabase : RoomDatabase() {
    
    abstract fun chatDao(): ChatDao
    abstract fun messageDao(): MessageDao
    abstract fun userDao(): UserDao
    
    companion object {
        @Volatile
        private var INSTANCE: ChatDatabase? = null
        
        fun getInstance(context: Context): ChatDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ChatDatabase::class.java,
                    "hypechats_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

@Dao
interface ChatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChat(chat: Chat)
    
    @Query("SELECT * FROM chats ORDER BY lastMessageTime DESC")
    suspend fun getAllChats(): List<Chat>
    
    @Query("SELECT * FROM chats WHERE id = :chatId")
    suspend fun getChatById(chatId: String): Chat?
    
    @Delete
    suspend fun deleteChat(chat: Chat)
}

@Dao
interface MessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: Message)
    
    @Query("SELECT * FROM messages WHERE chatId = :chatId ORDER BY timestamp ASC")
    suspend fun getMessagesByChatId(chatId: String): List<Message>
    
    @Delete
    suspend fun deleteMessage(message: Message)
}

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)
    
    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<User>
    
    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUserById(userId: String): User?
    
    @Delete
    suspend fun deleteUser(user: User)
}