package com.example.petkarecopy

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreateAddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_address)
        val backBtn=findViewById<ImageView>(R.id.btn_back)
        backBtn.setOnClickListener {
            finish()
        }
        val headerBtn=findViewById<TextView>(R.id.btn_header_save)
        headerBtn.setOnClickListener {
            finish()
        }
        val saveAddBtn=findViewById<TextView>(R.id.btn_save_address)
        saveAddBtn.setOnClickListener {
            finish()
        }
    }
}