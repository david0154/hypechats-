# HypeChats - Android Social Media App

## Overview
HypeChats is a modern social media application built with **Kotlin** and **Android Studio**. It features real-time messaging, face filters, location sharing, and image editing.

## Features
- ✅ Real-time Messaging
- ✅ Face Filters & Effects  
- ✅ Location Sharing
- ✅ Image Editing
- ✅ User Profiles
- ✅ Material Design 3

## Tech Stack
- **Language**: Kotlin
- **Architecture**: MVVM + Repository Pattern
- **Networking**: Retrofit + OkHttp
- **Async**: Coroutines
- **UI**: Material Design 3, ViewBinding
- **Maps**: Google Maps + Places
- **Camera**: AndroidX Camera

## Project Structure
```
app/src/main/java/com/davidstudioz/hypechats/
├── activities/          # Main screens
├── fragments/           # UI fragments
├── ui/                  # Custom UI components
├── api/                 # Retrofit API service
├── models/              # Data models
├── repositories/        # Data repositories
├── viewmodels/          # MVVM ViewModels
├── utils/               # Utilities
├── adapters/            # RecyclerView adapters
└── services/            # Background services
```

## Setup Instructions

### 1. Clone Repository
```bash
git clone https://github.com/david0154/hypechats-.git
cd hypechats
```

### 2. Configure API Endpoints
Edit `app/src/main/java/com/davidstudioz/hypechats/api/ApiClient.kt`:
```kotlin
private const val BASE_URL = "https://your-api.com/api/"
```

### 3. Add Google Maps API Key
Edit `app/src/main/AndroidManifest.xml`:
```xml
<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="YOUR_GOOGLE_MAPS_API_KEY" />
```

### 4. Build & Run
```bash
./gradlew build
./gradlew installDebug
```

## API Endpoints

### Authentication
- `POST /auth/login` - Login user
- `POST /auth/register` - Register new user

### Messaging
- `GET /chat/conversations` - Get all conversations
- `POST /chat/send` - Send message
- `GET /chat/{chatId}/messages` - Get messages

### Filters
- `GET /filters/list` - Get all filters

## Permissions Required
```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

## Building for Release
```bash
./gradlew bundleRelease
```

## License
Copyright © 2026 David Studioz. All rights reserved.

## Contact
- GitHub: https://github.com/david0154
- Website: https://davidstudioz.com

**Version**: 1.0.0  
**Last Updated**: January 9, 2026