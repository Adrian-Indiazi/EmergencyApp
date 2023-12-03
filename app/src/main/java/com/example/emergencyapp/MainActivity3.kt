package com.example.emergencyapp

import android.annotation.SuppressLint
import android.content.Intent
import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat

class MainActivity3 : AppCompatActivity() {
    val phoneNumber = "+254111771685"
    val REQUEST_PHONE_CALL = 1

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val btnReport = findViewById<Button>(R.id.report)
        val callButton = findViewById<ImageView>(R.id.call_Image)

          //Opening google maps to report emergency
        btnReport.setOnClickListener {
            val intent = Intent(this, Map::class.java)
            startActivity(/* intent = */ intent)

        }

           //setting quick call for emergency
        callButton.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    REQUEST_PHONE_CALL
                )
            } else {
                startCall()
            }
        }




    }

    //requesting permission to make a call on the android phone
    @SuppressLint("MissingPermission")
    private fun startCall() {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:" + phoneNumber)
        startActivity(callIntent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PHONE_CALL) startCall()
    }


}
