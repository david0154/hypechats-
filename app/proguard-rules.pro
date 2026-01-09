# ProGuard rules for HypeChats

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
}

# Keep model classes
-keep class com.davidstudioz.hypechats.models.** { *; }
-keep class com.davidstudioz.hypechats.api.** { *; }

# Retrofit
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

# OkHttp
-dontwarn okhttp3.**
-keep class okhttp3.** { *; }

# Gson
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

# Kotlin
-keep class kotlin.Metadata { *; }
-dontwarn kotlin.**

# Google Play Services
-keep class com.google.android.gms.** { *; }
-dontwarn com.google.android.gms.**

# Glide
-keep public class * implements com.bumptech.glide.module.GlideModule

# Preserve line numbers
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile