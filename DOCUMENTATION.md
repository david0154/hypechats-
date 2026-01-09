# HypeChats Android App - Complete Technical Documentation

## Table of Contents
1. [Architecture](#architecture)
2. [Project Structure](#project-structure)
3. [API Integration](#api-integration)
4. [Key Features](#key-features)
5. [Code Examples](#code-examples)

## Architecture

### MVVM Pattern
The app follows Model-View-ViewModel (MVVM) architecture with Repository pattern:

```
UI Layer (Activities/Fragments)
         ↓
   ViewModel Layer
         ↓
  Repository Layer
         ↓
Data Layer (API/Database)
```

### Key Components
1. **Views** - Display UI and observe ViewModel data
2. **ViewModels** - Manage UI logic and hold LiveData
3. **Repositories** - Handle data operations
4. **Data Sources** - API (Retrofit) and Local DB

## Project Structure

### activities/
- `MainActivity.kt` - Main app screen
- `LoginActivity.kt` - Authentication screen
- `SplashActivity.kt` - Splash screen

### api/
- `ApiClient.kt` - Retrofit configuration
- `ApiService.kt` - API endpoints interface

### models/
Data classes:
- User, Chat, Message
- FaceFilter, Location
- Authentication models

### repositories/
- `ChatRepository` - Chat operations
- `UserRepository` - User operations
- `FilterRepository` - Filter operations

### viewmodels/
- `MainViewModel` - Main screen logic
- `ChatViewModel` - Chat screen logic
- `FilterViewModel` - Filter management

### utils/
- `Constants.kt` - App constants
- `ImageUtils.kt` - Image operations
- `LocationUtils.kt` - Location operations
- `NetworkUtils.kt` - Network checking

## API Integration

### Configuration
```kotlin
private const val BASE_URL = "https://api.hypechats.com/api/"
```

### Making Calls
```kotlin
val response = apiService.getMessages(chatId)
if (response.isSuccessful) {
    val messages = response.body()
}
```

## Key Features

### Real-time Messaging
- Send/receive text messages
- Media sharing (images, videos)
- Location sharing
- Read receipts

### Face Filters
- 20+ built-in filters
- Real-time camera preview
- Video recording

### Location Services
- GPS tracking
- Google Maps integration
- Nearby places discovery

### Image Editing
- Crop & rotate
- Color adjustment
- Effects & filters

## Code Examples

### Load Messages
```kotlin
fun loadMessages(chatId: String) {
    viewModelScope.launch {
        val messages = chatRepository.getMessages(chatId)
        _messages.value = messages
    }
}
```

### Send Message
```kotlin
val message = Message(
    chatId = currentChatId,
    senderId = currentUserId,
    content = userInput
)
chatRepository.sendMessage(message)
```

### Get Current Location
```kotlin
val addresses = LocationUtils.getAddressFromLocation(
    context,
    latitude,
    longitude
)
```

## Permissions
```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

## Building for Production
```bash
./gradlew bundleRelease
```

ProGuard is enabled and properly configured for production.

---
**Version**: 1.0.0  
**Last Updated**: January 9, 2026