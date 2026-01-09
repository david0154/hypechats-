package com.davidstudioz.hypechats.utils

object Constants {
    // API Configuration
    const val API_BASE_URL = "https://api.hypechats.com/api/"
    const val API_TIMEOUT = 30L
    const val API_READ_TIMEOUT = 30L
    const val API_WRITE_TIMEOUT = 30L
    
    // Intent Extras
    const val CHAT_ID = "chat_id"
    const val CHAT_NAME = "chat_name"
    const val USER_ID = "user_id"
    const val IMAGE_PATH = "image_path"
    const val CAMERA_FILE_PATH = "camera_file_path"
    const val LOCATION_LAT = "location_lat"
    const val LOCATION_LNG = "location_lng"
    
    // Shared Preferences Keys
    const val PREFS_NAME = "HypeChatsPrefs"
    const val USER_TOKEN = "user_token"
    const val USER_ID_PREF = "user_id"
    const val USER_DATA = "user_data"
    const val IS_LOGGED_IN = "is_logged_in"
    
    // Message Types
    const val MESSAGE_TYPE_TEXT = "text"
    const val MESSAGE_TYPE_IMAGE = "image"
    const val MESSAGE_TYPE_LOCATION = "location"
    const val MESSAGE_TYPE_VOICE = "voice"
    
    // Timing
    const val MESSAGE_CHECK_INTERVAL = 30000L // 30 seconds
    const val CONNECTION_RETRY_INTERVAL = 5000L // 5 seconds
    
    // File Paths
    const val CACHE_IMAGE_DIR = "cache_images"
    const val CACHE_VOICE_DIR = "cache_voice"
    
    // Permissions
    const val PERMISSION_CAMERA = android.Manifest.permission.CAMERA
    const val PERMISSION_LOCATION = android.Manifest.permission.ACCESS_FINE_LOCATION
    const val PERMISSION_STORAGE = android.Manifest.permission.READ_EXTERNAL_STORAGE
}