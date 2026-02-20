package com.example.petkarecopy

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreateAddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_address)
        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }
        val btnSave = findViewById<TextView>(R.id.btn_save)
        btnSave.setOnClickListener {
            finish()
        }
        val spinnerType = findViewById<Spinner>(R.id.spinner_address_type)
        val addressTypes = arrayOf("Home", "Work", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, addressTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerType.adapter = adapter
    }
}