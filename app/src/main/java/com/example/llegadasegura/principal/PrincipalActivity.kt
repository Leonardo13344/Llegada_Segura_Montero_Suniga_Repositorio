package com.example.llegadasegura.principal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.llegadasegura.R
import com.example.llegadasegura.databinding.ActivityPrincipalBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class PrincipalActivity : AppCompatActivity(), OnMapReadyCallback {
    //private lateinit var binding: ActivityPrincipalBinding

    private lateinit var map: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_principal)
        createFragment()


    }
    private fun createFragment(){
        val mapFragment : SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }
}