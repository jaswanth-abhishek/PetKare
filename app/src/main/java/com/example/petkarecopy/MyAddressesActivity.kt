package com.example.petkarecopy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MyAddressesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_addresses)
        val btnBack=findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }
        val btnAdd=findViewById<ImageView>(R.id.btn_add)
        btnAdd.setOnClickListener {
            val intent=Intent(this, CreateAddressActivity::class.java)
            startActivity(intent)
        }

        val cardAddress1=findViewById<LinearLayout>(R.id.card_address_1)
        cardAddress1.setOnClickListener {
            val intent=Intent(this, EditAddressActivity::class.java)
            startActivity(intent)
        }
    }
}