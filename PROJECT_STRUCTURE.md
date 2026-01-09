# HypeChats Android - Complete Project Structure

## Directory Tree

```
hypechats/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/davidstudioz/hypechats/
│   │   │   │   ├── activities/
│   │   │   │   │   ├── MainActivity.kt          # Main app screen
│   │   │   │   │   ├── LoginActivity.kt        # Login screen
│   │   │   │   │   └── SplashActivity.kt       # Splash screen
│   │   │   │   │
│   │   │   │   ├── fragments/              # UI Fragments
│   │   │   │   ├── api/
│   │   │   │   │   ├── ApiClient.kt           # Retrofit configuration
│   │   │   │   │   └── ApiService.kt          # API endpoints
│   │   │   │   │
│   │   │   │   ├── models/
│   │   │   │   │   └── Models.kt              # Data classes
│   │   │   │   │
│   │   │   │   ├── repositories/
│   │   │   │   │   ├── ChatRepository.kt      # Chat operations
│   │   │   │   │   ├── UserRepository.kt      # User operations
│   │   │   │   │   └── FilterRepository.kt    # Filter operations
│   │   │   │   │
│   │   │   │   ├── viewmodels/
│   │   │   │   │   ├── MainViewModel.kt       # Main screen logic
│   │   │   │   │   └── ChatViewModel.kt       # Chat screen logic
│   │   │   │   │
│   │   │   │   ├── adapters/
│   │   │   │   │   ├── MessageAdapter.kt      # Message list adapter
│   │   │   │   │   ├── ChatAdapter.kt         # Chat list adapter
│   │   │   │   │   └── FilterAdapter.kt       # Filter list adapter
│   │   │   │   │
│   │   │   │   ├── utils/
│   │   │   │   │   ├── Constants.kt           # App constants
│   │   │   │   │   ├── SessionManager.kt      # Session/Auth management
│   │   │   │   │   ├── ImageUtils.kt          # Image operations
│   │   │   │   │   ├── LocationUtils.kt       # Location operations
│   │   │   │   │   ├── NetworkUtils.kt        # Network checking
│   │   │   │   │   ├── ValidationUtils.kt     # Input validation
│   │   │   │   │   └── DateTimeUtils.kt       # Date/time formatting
│   │   │   │   │
│   │   │   │   ├── ui/                    # Custom UI components
│   │   │   │   └── services/              # Background services
│   │   │   │
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml      # Main activity layout
│   │   │   │   │   ├── activity_login.xml     # Login activity layout
│   │   │   │   │   ├── activity_splash.xml    # Splash activity layout
│   │   │   │   │   ├── item_message.xml       # Message list item
│   │   │   │   │   ├── item_chat.xml          # Chat list item
│   │   │   │   │   └── item_filter.xml        # Filter list item
│   │   │   │   │
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml            # String resources
│   │   │   │   │   ├── colors.xml             # Color definitions
│   │   │   │   │   └── dimens.xml             # Dimension definitions
│   │   │   │   │
│   │   │   │   ├── mipmap-*/              # App icons
│   │   │   │   └── drawable-*/            # Drawable resources
│   │   │   │
│   │   │   └── AndroidManifest.xml    # App manifest
│   │   │
│   │   ├── test/                  # Unit tests
│   │   └── androidTest/           # Instrumentation tests
│   │
│   ├── build.gradle           # App build configuration
│   ├── proguard-rules.pro     # ProGuard rules
│   └── .gitignore             # Git ignore rules
│
├── build.gradle           # Project build configuration
├── settings.gradle        # Gradle settings
├── gradle.properties      # Gradle properties
├── gradlew                # Gradle wrapper (Unix)
├── gradlew.bat            # Gradle wrapper (Windows)
├── README.md              # Project README
├── DOCUMENTATION.md       # Technical documentation
├── SETUP_GUIDE.md         # Setup instructions
├── PROJECT_STRUCTURE.md   # This file
├── CONTRIBUTING.md        # Contributing guidelines
├── LICENSE                # License file
└── .github/
    └── workflows/
        └── android.yml        # CI/CD workflow
```

## File Descriptions

### Core Layers

#### API Layer (`api/`)
- **ApiClient.kt** - Configures Retrofit instance with OkHttp
- **ApiService.kt** - Defines all API endpoints using Retrofit

#### Model Layer (`models/`)
- **Models.kt** - Data classes for JSON serialization/deserialization

#### Repository Layer (`repositories/`)
- **ChatRepository.kt** - Handles chat-related API calls
- **UserRepository.kt** - Handles user authentication and profile
- **FilterRepository.kt** - Handles face filter operations

#### ViewModel Layer (`viewmodels/`)
- **MainViewModel.kt** - Manages main screen logic and data
- **ChatViewModel.kt** - Manages chat screen logic and messages

#### UI Layer
- **Activities** - App screens (MainActivity, LoginActivity, SplashActivity)
- **Fragments** - Composable screen fragments
- **Adapters** - RecyclerView adapters for lists
- **Layouts** - XML layouts for screens and list items

#### Utilities (`utils/`)
- **Constants.kt** - All app constants
- **SessionManager.kt** - Authentication token and user session management
- **ImageUtils.kt** - Image loading, compression, rotation
- **LocationUtils.kt** - Geocoding and location calculations
- **NetworkUtils.kt** - Internet connectivity checking
- **ValidationUtils.kt** - Input validation for forms
- **DateTimeUtils.kt** - Date and time formatting

### Configuration Files

- **AndroidManifest.xml** - App permissions and component declarations
- **build.gradle** - Dependencies and build settings
- **proguard-rules.pro** - Code obfuscation rules for production
- **gradle.properties** - Gradle build properties

### Resource Files

- **strings.xml** - Text strings and labels
- **colors.xml** - Color palette
- **dimens.xml** - Dimensions and spacing
- **layouts/** - XML layouts for activities and list items
- **mipmap/** - App icons in multiple densities
- **drawable/** - Drawable resources

## Architecture Pattern

```
┌─────────────────────┐
│   Activities/UI     │
│  (Display & Input)  │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│    ViewModel        │
│  (State Management) │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│    Repository       │
│ (Data Operations)   │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│   Data Sources      │
│ (API / Database)    │
└─────────────────────┘
```

## Key Technologies

### Networking
- **Retrofit** - REST client
- **OkHttp** - HTTP client with logging
- **Gson** - JSON serialization

### Async
- **Coroutines** - Asynchronous programming
- **Flow** - Reactive streams

### UI
- **AndroidX** - Modern Android libraries
- **Material Design 3** - UI components
- **ViewBinding** - Type-safe view access

### Lifecycle
- **LiveData** - Observable data holder
- **ViewModel** - UI state management
- **Lifecycle** - Lifecycle-aware components

### Media
- **Glide** - Image loading library
- **Camera X** - Modern camera API
- **Media3** - Audio/video playback

### Location
- **Google Play Services** - Maps and location services
- **Location API** - Device location tracking

## Dependencies Summary

### Core
```gradle
implementation 'androidx.core:core-ktx:1.12.0'
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.6.2'
```

### Networking
```gradle
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'com.squareup.okhttp3:okhttp:4.11.0'
```

### Async
```gradle
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3'
```

### UI
```gradle
implementation 'com.google.android.material:material:1.10.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
```

## Module Organization

### By Feature
- **auth/** - Authentication screens and logic
- **chat/** - Chat screens and messaging
- **profile/** - User profile and settings
- **explore/** - Discovery and filters

### By Layer
- **api/** - Network calls
- **models/** - Data models
- **repositories/** - Data logic
- **viewmodels/** - Screen logic
- **ui/** - Views and adapters

## Build Variants

### Debug
- All logging enabled
- No code obfuscation
- Debuggable
- Network traffic logging

### Release
- ProGuard enabled
- No logging
- Signing certificate required
- Optimized for performance

## Gradle Tasks

```bash
# Build
./gradlew build
./gradlew assembleDebug
./gradlew assembleRelease
./gradlew bundleRelease

# Test
./gradlew test
./gradlew androidTest

# Clean
./gradlew clean
./gradlew cleanBuild
```

---

**Version**: 1.0.0  
**Last Updated**: January 9, 2026  
**Maintained By**: David Studioz