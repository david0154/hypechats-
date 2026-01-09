package com.davidstudioz.hypechats.utils

import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtils {
    private const val FORMAT_TIME_12 = "hh:mm a"
    private const val FORMAT_TIME_24 = "HH:mm"
    private const val FORMAT_DATE = "dd/MM/yyyy"
    private const val FORMAT_FULL = "dd/MM/yyyy HH:mm:ss"
    private const val FORMAT_ISO = "yyyy-MM-dd'T'HH:mm:ss"

    fun getFormattedTime(timestamp: Long, format: String = FORMAT_TIME_24): String {
        val date = Date(timestamp)
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        return sdf.format(date)
    }

    fun getFormattedDate(timestamp: Long, format: String = FORMAT_DATE): String {
        val date = Date(timestamp)
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        return sdf.format(date)
    }

    fun getTimeAgo(timestamp: Long): String {
        val now = System.currentTimeMillis()
        val diff = now - timestamp

        return when {
            diff < 60000 -> "Just now"
            diff < 3600000 -> "${diff / 60000} min ago"
            diff < 86400000 -> "${diff / 3600000} hours ago"
            diff < 604800000 -> "${diff / 86400000} days ago"
            else -> SimpleDateFormat(FORMAT_DATE, Locale.getDefault()).format(Date(timestamp))
        }
    }
}