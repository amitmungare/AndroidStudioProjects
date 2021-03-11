package com.example.mapsandlocation

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.mapsandlocation.databinding.ActivityMapsBinding
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    val locationManager by lazy {
        getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStart() {
        requestAccessFineLocation()
        super.onStart()
        when{
            isFineLocationGranted()->{
                when{
                    isLocationEnable()->setupLocationListener()
                    else->showGPSNotEnableDialog()
                }
            }
            else->requestAccessFineLocation()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            999 -> if(grantResults.isNotEmpty()&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
//                setupLocationListener()
                when{
                    isLocationEnable()->setupLocationListener()
                    else->showGPSNotEnableDialog()
                }
            }else{
                Toast.makeText(this,"permission not granted",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setupLocationListener() {
        val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        val locationRequest = LocationRequest()
            .setInterval(2000)
            .setFastestInterval(2000)
            .setSmallestDisplacement(1f)
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest,object :LocationCallback(){
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                for (location in locationResult.locations){
                    val current = LatLng(location.latitude, location.longitude)

                    if(::mMap.isInitialized){
                        mMap.addMarker(MarkerOptions().position(current).title("My Home"))
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(current))
                        }
                }
            }
        }, Looper.myLooper()
        )

    }

//    @SuppressLint("missing permission")
//    private fun setupLocationListener() {
//
//
//        val providers = locationManager.getProviders(true)
//
//        var l:Location? = null
//        for (i in providers.indices.reversed()){
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                return
//            }
//            l= locationManager.getLastKnownLocation(providers[i])
//            if (l != null)break
//        }
//
//        l?.let {
//            if(::mMap.isInitialized){
//                val current = LatLng(15.466570, 73.852734)
//                mMap.addMarker(MarkerOptions().position(current).title("My Home"))
//                mMap.moveCamera(CameraUpdateFactory.newLatLng(current))
//            }
//        }
//
//    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun isFineLocationGranted():Boolean{
        return checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) ==PackageManager.PERMISSION_GRANTED
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun requestAccessFineLocation() {
        this.requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),999
        )
    }

    fun isLocationEnable():Boolean {
        return locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    fun showGPSNotEnableDialog(){
        AlertDialog.Builder(this)
                .setTitle("Enable GPS")
                .setMessage("GPS is required")
                .setCancelable(false)
                .setPositiveButton("Enable Now"){ dialogInterface: DialogInterface, i: Int ->
                    startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                    dialogInterface.dismiss()
                }.show()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.apply {
            isZoomControlsEnabled=true
            isZoomGesturesEnabled=true
            isMyLocationButtonEnabled=true
            isCompassEnabled=true
        }

        mMap.setMaxZoomPreference(22f)

        val sydney = LatLng(15.466570, 73.852734)
        mMap.addMarker(MarkerOptions().position(sydney).title("My Home"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        mMap.addPolyline(
                PolylineOptions().add(LatLng(23.45,75.34), LatLng(45.45,95.34))
                        .color(ContextCompat.getColor(baseContext,R.color.design_default_color_primary))
        ).width=2f
    }
}