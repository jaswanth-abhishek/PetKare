package com.example.petkarecopy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyAddressesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_addresses)
        findViewById<ImageView>(R.id.btn_back).setOnClickListener {
            finish()
        }
        findViewById<ImageView>(R.id.btn_add_address).setOnClickListener {
            startActivity(Intent(this, CreateAddressActivity::class.java))
        }
        val rvAddresses = findViewById<RecyclerView>(R.id.rv_addresses)
        rvAddresses.layoutManager = LinearLayoutManager(this)
        val addressList = listOf(
            Address("Home", "123 Main St, Karigiri", "Home"),
            Address("Work", "Tech Park, Sector 5, Vellore", "Work")
        )
        val adapter = AddressAdapter(addressList) { selectedAddress ->
            val intent = Intent(this, EditAddressActivity::class.java)
            startActivity(intent)
        }
        rvAddresses.adapter = adapter
    }
}