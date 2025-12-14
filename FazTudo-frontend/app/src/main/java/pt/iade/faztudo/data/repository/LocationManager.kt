package pt.iade.faztudo.data.repository

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Looper
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.util.Locale

data class LocationData(
    val latitude: Double,
    val longitude: Double,
    val cidade: String? = null,
    val morada: String? = null,
    val codigoPostal: String? = null
)

class LocationManager(private val context: Context) {

    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    private val locationRequest = LocationRequest.Builder(
        Priority.PRIORITY_HIGH_ACCURACY,
        10000L // 10s
    ).apply {
        setMinUpdateIntervalMillis(5000L)
        setMaxUpdates(1)
    }.build()

   // localização
    fun hasLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED ||
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }


    fun getLastLocation(): Flow<LocationData?> = callbackFlow {
        if (!hasLocationPermission()) {
            trySend(null)
            close()
            return@callbackFlow
        }

        try {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location ->
                    if (location != null) {
                        val locationData = LocationData(
                            latitude = location.latitude,
                            longitude = location.longitude
                        )
                        // obter o endereço
                        val enrichedData = enrichLocationWithAddress(locationData)
                        trySend(enrichedData)
                    } else {
                        trySend(null)
                    }
                    close()
                }
                .addOnFailureListener {
                    trySend(null)
                    close()
                }
        } catch (e: SecurityException) {
            trySend(null)
            close()
        }

        awaitClose { }
    }

    fun getCurrentLocation(): Flow<LocationData?> = callbackFlow {
        if (!hasLocationPermission()) {
            trySend(null)
            close()
            return@callbackFlow
        }

        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(result: LocationResult) {
                result.lastLocation?.let { location ->
                    val locationData = LocationData(
                        latitude = location.latitude,
                        longitude = location.longitude
                    )
                    val enrichedData = enrichLocationWithAddress(locationData)
                    trySend(enrichedData)
                } ?: trySend(null)
                
                fusedLocationClient.removeLocationUpdates(this)
                close()
            }
        }

        try {
            fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.getMainLooper()
            )
        } catch (e: SecurityException) {
            trySend(null)
            close()
        }

        awaitClose {
            fusedLocationClient.removeLocationUpdates(locationCallback)
        }
    }


    private fun enrichLocationWithAddress(locationData: LocationData): LocationData {
        return try {
            val geocoder = Geocoder(context, Locale("pt", "PT"))
            
            @Suppress("DEPRECATION")
            val addresses = geocoder.getFromLocation(
                locationData.latitude,
                locationData.longitude,
                1
            )

            if (!addresses.isNullOrEmpty()) {
                val address = addresses[0]
                locationData.copy(
                    cidade = address.locality ?: address.subAdminArea ?: address.adminArea,
                    morada = address.getAddressLine(0)?.split(",")?.firstOrNull()?.trim(),
                    codigoPostal = address.postalCode
                )
            } else {
                locationData
            }
        } catch (e: Exception) {
            locationData
        }
    }


    fun calculateDistance(
        lat1: Double, lon1: Double,
        lat2: Double, lon2: Double
    ): Double {
        val r = 6371.0

        val lat1Rad = Math.toRadians(lat1)
        val lat2Rad = Math.toRadians(lat2)
        val deltaLat = Math.toRadians(lat2 - lat1)
        val deltaLon = Math.toRadians(lon2 - lon1)

        val a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2)

        val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))

        return r * c
    }
}
