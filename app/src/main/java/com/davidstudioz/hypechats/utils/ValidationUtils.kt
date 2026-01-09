package com.davidstudioz.hypechats.utils

import android.util.Patterns

object ValidationUtils {
    fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }

    fun isValidName(name: String): Boolean {
        return name.trim().length >= 2
    }

    fun isValidPhoneNumber(phone: String): Boolean {
        return phone.length >= 10 && phone.all { it.isDigit() }
    }

    fun isValidUrl(url: String): Boolean {
        return Patterns.WEB_URL.matcher(url).matches()
    }

    fun validateLoginForm(email: String, password: String): Pair<Boolean, String> {
        return when {
            email.isEmpty() -> Pair(false, "Email is required")
            !isValidEmail(email) -> Pair(false, "Email format is invalid")
            password.isEmpty() -> Pair(false, "Password is required")
            !isValidPassword(password) -> Pair(false, "Password must be at least 6 characters")
            else -> Pair(true, "")
        }
    }
}