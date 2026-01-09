package com.davidstudioz.hypechats.utils

object Constants {
    const val SHARED_PREF_NAME = "hypechats_prefs"
    const val KEY_TOKEN = "auth_token"
    const val KEY_USER_ID = "user_id"
    const val KEY_USER_EMAIL = "user_email"
    const val KEY_USER_NAME = "user_name"
    const val KEY_IS_LOGGED_IN = "is_logged_in"
    
    const val DATABASE_NAME = "hypechats_db"
    
    // API
    const val CONNECT_TIMEOUT = 30L
    const val READ_TIMEOUT = 30L
    const val WRITE_TIMEOUT = 30L
    
    // Location
    const val DEFAULT_ZOOM_LEVEL = 18f
    const val MIN_LOCATION_UPDATE_DISTANCE = 10f
    const val MIN_LOCATION_UPDATE_TIME = 1000L
    
    // Image
    const val MAX_IMAGE_SIZE = 5 * 1024 * 1024
    const val COMPRESSION_QUALITY = 85
    
    // Pagination
    const val PAGE_SIZE = 20
    
    // Request codes
    const val REQUEST_CAMERA = 1
    const val REQUEST_GALLERY = 2
    const val REQUEST_LOCATION = 3
    const val REQUEST_PERMISSIONS = 4
    
    // Message types
    const val MESSAGE_TYPE_TEXT = "text"
    const val MESSAGE_TYPE_IMAGE = "image"
    const val MESSAGE_TYPE_VIDEO = "video"
    const val MESSAGE_TYPE_LOCATION = "location"
}