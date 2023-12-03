package com.example.emergencyapp


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //moving to the next Activity
        val btnMove= findViewById<TextView>(R.id.reg_txtView)
        val btnLogin=findViewById<Button>(R.id.login)
        btnMove.setOnClickListener {
            val intent = Intent (this, MainActivity2::class.java)
            startActivity(/* intent = */ intent)

        }
        btnLogin.setOnClickListener {
            val intent = Intent (this, MainActivity3::class.java)
            startActivity(/* intent = */ intent)
        }
    }
}
