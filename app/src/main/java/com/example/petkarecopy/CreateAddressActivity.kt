package com.example.petkarecopy

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateAddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_address)
        findViewById<ImageView>(R.id.btn_back).setOnClickListener { finish() }
        val spinnerType = findViewById<Spinner>(R.id.spinner_address_type)
        val addressTypes = arrayOf("Home", "Work", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, addressTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerType.adapter = adapter
        val btnSave = findViewById<TextView>(R.id.btn_save)
        btnSave.setOnClickListener {
            val location = findViewById<EditText>(R.id.et_location).text.toString().trim()
            val city = findViewById<EditText>(R.id.et_city).text.toString().trim()
            val pincode = findViewById<EditText>(R.id.et_pincode).text.toString().trim()
            if (location.isEmpty() || city.isEmpty() || pincode.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Toast.makeText(this, "Address Saved Successfully!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}