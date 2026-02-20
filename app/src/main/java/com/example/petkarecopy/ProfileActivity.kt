package com.example.petkarecopy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val prefs = getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        val token = prefs.getString("authToken", null)
        val tvName = findViewById<TextView>(R.id.tv_profile_name)
        val tvEmail = findViewById<TextView>(R.id.tv_profile_email)
        if (token != null) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val response = RetrofitClient.instance.getProfile("Bearer $token")
                    if (response.isSuccessful && response.body() != null) {
                        val profile = response.body()!!
                        withContext(Dispatchers.Main) {
                            tvName.text = profile.displayName ?: "User"
                            tvEmail.text = profile.email
                            Log.d("API", "Fetched Profile: ${profile.email}")
                        }
                    } else {
                        Log.e("API", "Failed to fetch profile")
                    }
                } catch (e: Exception) {
                    Log.e("API", "Network Error: ${e.message}")
                }
            }
        } else {
            Toast.makeText(this, "Not logged in", Toast.LENGTH_SHORT).show()
        }
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
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
        findViewById<TextView>(R.id.btn_logout).setOnClickListener {
            prefs.edit().remove("authToken").apply()
            if (token != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        RetrofitClient.instance.logout("Bearer $token")
                    } catch (e: Exception) {
                        Log.e("API", "Server Logout Failed")
                    }
                }
            }
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}