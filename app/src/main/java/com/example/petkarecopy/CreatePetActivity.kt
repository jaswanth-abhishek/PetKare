package com.example.petkarecopy

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreatePetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_pet)
        val btnBack=findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }
        val btnHeaderSave=findViewById<TextView>(R.id.btn_header_save)
        btnHeaderSave.setOnClickListener {
            finish()
        }
        val btnSavePet=findViewById<TextView>(R.id.btn_save_pet)
        btnSavePet.setOnClickListener { finish() }
    }
}