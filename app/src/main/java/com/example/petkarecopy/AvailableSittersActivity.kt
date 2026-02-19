package com.example.petkarecopy

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class AvailableSittersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_available_sitters)
        val btnBack=findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }
    }
}