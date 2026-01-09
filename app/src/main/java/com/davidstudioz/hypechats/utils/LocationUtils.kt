package com.davidstudioz.hypechats.utils

import android.location.Location
import kotlin.math.*

object LocationUtils {
    
    fun calculateDistance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Float {
        val results = FloatArray(1)
        Location.distanceBetween(lat1, lon1, lat2, lon2, results)
        return results[0]
    }
    
    fun formatDistance(distanceInMeters: Float): String {
        return when {
            distanceInMeters < 1000 -> String.format("%.0f m", distanceInMeters)
            distanceInMeters < 1000000 -> String.format("%.2f km", distanceInMeters / 1000)
            else -> String.format("%.0f km", distanceInMeters / 1000)
        }
    }
    
    fun getBearing(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Float {
        val dLon = Math.toRadians(lon2 - lon1)
        val y = sin(dLon) * cos(Math.toRadians(lat2))
        val x = cos(Math.toRadians(lat1)) * sin(Math.toRadians(lat2)) -
                sin(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) * cos(dLon)
        
        val bearing = Math.toDegrees(atan2(y, x))
        return (bearing + 360) % 360f
    }
}