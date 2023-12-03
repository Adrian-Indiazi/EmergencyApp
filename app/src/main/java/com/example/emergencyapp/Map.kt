package com.example.emergencyapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.karumi.dexter.Dexter
import kotlin.collections.Map

class Map : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        val openReport = findViewById<Button>(R.id.map_Proceed)
        openReport.setOnClickListener {
            val intent = Intent(this, Report_emergency::class.java)
            startActivity(/* intent = */ intent)
        }
    }


}