# HypeChats Android - Complete Setup Guide

## 🚀 Quick Start

### Step 1: Clone Repository
```bash
git clone https://github.com/david0154/hypechats-.git
cd hypechats
```

### Step 2: Open in Android Studio
1. Open Android Studio
2. Select "Open an Existing Project"
3. Navigate to the cloned directory
4. Click Open

### Step 3: Gradle Sync
- Android Studio will automatically sync Gradle files
- Wait for completion
- If issues, try: `./gradlew clean sync`

### Step 4: Configure API

**File**: `app/src/main/java/com/davidstudioz/hypechats/api/ApiClient.kt`

```kotlin
private const val BASE_URL = "https://your-backend-api.com/api/"
```

### Step 5: Google Maps API Key

**File**: `app/src/main/AndroidManifest.xml`

```xml
<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="YOUR_GOOGLE_MAPS_API_KEY_HERE" />
```

To get your API key:
1. Go to [Google Cloud Console](https://console.cloud.google.com/)
2. Create a new project
3. Enable Maps & Places APIs
4. Create API key
5. Copy and paste in AndroidManifest.xml

### Step 6: Run the App

**Option A - Emulator**:
```bash
./gradlew installDebug
```

**Option B - Physical Device**:
1. Connect device via USB
2. Enable USB Debugging on device
3. Run: `./gradlew installDebug`

---

## 📋 Project Checklist

### Pre-Launch
- [ ] API endpoint configured
- [ ] Google Maps API key added
- [ ] All permissions in manifest
- [ ] App name/logo customized
- [ ] Colors/themes configured

### Build Configuration
- [ ] Gradle sync successful
- [ ] No build errors
- [ ] ProGuard rules enabled
- [ ] Build types configured (debug/release)

### Testing
- [ ] App launches without crash
- [ ] Login screen appears
- [ ] API calls working (check logcat)
- [ ] Permissions working
- [ ] Camera/Location working

### Release Preparation
- [ ] Version code incremented
- [ ] Version name updated
- [ ] Release notes prepared
- [ ] Keystore file created
- [ ] ProGuard enabled

---

## 🔧 Customization

### App Name
**File**: `app/src/main/res/values/strings.xml`
```xml
<string name="app_name">Your App Name</string>
```

### App Colors
**File**: `app/src/main/res/values/colors.xml`
```xml
<color name="primary">#YourColorCode</color>
<color name="secondary">#YourColorCode</color>
```

### App Icon
Replace files in `app/src/main/res/mipmap-*/`:
- `ic_launcher.png` - App icon
- `ic_launcher_background.xml` - Background
- `ic_launcher_foreground.xml` - Foreground

### Splash Screen
**File**: `app/src/main/res/layout/activity_splash.xml`
Customize the splash screen design and add your logo.

---

## 🔐 Security Configuration

### API Security
- Add authentication header to all requests
- Use HTTPS only
- Implement token refresh
- Validate SSL certificates

### Data Security
- Use SharedPreferences for sensitive data
- Encrypt stored tokens
- Never log sensitive data
- Implement ProGuard obfuscation

### Permissions
All required permissions are already in `AndroidManifest.xml`:
- INTERNET
- CAMERA
- LOCATION
- STORAGE
- AUDIO

---

## 📱 Device Requirements

### Minimum
- SDK: 24 (Android 7.0)
- RAM: 2GB
- Screen: 4.5 inches

### Target
- SDK: 34 (Android 14)
- RAM: 4GB+
- Screen: 5.0+ inches

---

## 🐛 Troubleshooting

### Build Issues

**Gradle Sync Failed**
```bash
./gradlew clean
./gradlew sync
```

**Kotlin Compilation Error**
- Update Kotlin plugin
- File > Project Structure > SDK Version
- Use Kotlin 1.9.10+

**Dependency Conflicts**
```bash
./gradlew dependencyInsight --configuration implementation --dependency retrofit2
```

### Runtime Issues

**App Crashes on Launch**
- Check logcat: `adb logcat | grep hypechats`
- Verify API endpoint
- Check permissions

**API Returns 401**
- Token not present
- Token expired
- Invalid credentials

**Location Permission Denied**
- Grant permission in Settings
- Check runtime permissions
- Verify manifest permissions

**Camera Not Working**
- Device has no camera
- Permission not granted
- Camera in use by another app

### Debug Commands

```bash
# View logcat
adb logcat

# View app logs only
adb logcat | grep hypechats

# Clear app data
adb shell pm clear com.davidstudioz.hypechats

# Uninstall app
adb uninstall com.davidstudioz.hypechats

# Install app
adb install app/build/outputs/apk/debug/app-debug.apk
```

---

## 📦 Building Release APK/AAB

### Generate Keystore
```bash
keytool -genkey -v -keystore release.keystore \
  -keyalg RSA -keysize 2048 -validity 10000 \
  -alias hypechats
```

### Build Release APK
```bash
./gradlew assembleRelease
```
Output: `app/build/outputs/apk/release/app-release.apk`

### Build Release AAB (for Play Store)
```bash
./gradlew bundleRelease
```
Output: `app/build/outputs/bundle/release/app-release.aab`

---

## 📚 Documentation

- **API Docs**: See `DOCUMENTATION.md`
- **Architecture Guide**: See `DOCUMENTATION.md`
- **Code Examples**: See `DOCUMENTATION.md`

---

## 🤝 Support

**Issue Tracker**: [GitHub Issues](https://github.com/david0154/hypechats-/issues)

**Contact**: 
- Email: contact@davidstudioz.com
- Website: https://davidstudioz.com
- GitHub: https://github.com/david0154

---

## ✅ Final Checklist

- [ ] Cloned repository
- [ ] Opened in Android Studio
- [ ] Gradle sync complete
- [ ] API configured
- [ ] Google Maps key added
- [ ] Build successful
- [ ] App runs on emulator/device
- [ ] Login screen appears
- [ ] No crash errors
- [ ] Ready to deploy

**Next Steps**: 
1. Customize app colors and branding
2. Update API endpoints
3. Test all features
4. Build release APK
5. Deploy to Play Store

---

**Version**: 1.0.0  
**Last Updated**: January 9, 2026  
**Status**: ✅ Ready for Production