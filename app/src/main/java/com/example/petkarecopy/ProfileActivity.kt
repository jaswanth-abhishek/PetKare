package com.example.petkarecopy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        findViewById<View>(R.id.btn_my_pets).setOnClickListener {
            startActivity(Intent(this, MyPetsActivity::class.java))
        }
        findViewById<View>(R.id.btn_my_addresses).setOnClickListener {
            startActivity(Intent(this, MyAddressesActivity::class.java))
        }
        findViewById<TextView>(R.id.btn_edit_profile).setOnClickListener {
            startActivity(Intent(this, EditProfileActivity::class.java))
        }
        findViewById<View>(R.id.nav_home).setOnClickListener {
            val intent=Intent(this, HomeActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }
        findViewById<TextView>(R.id.btn_logout).setOnClickListener {
            val intent=Intent(this, LoginActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}