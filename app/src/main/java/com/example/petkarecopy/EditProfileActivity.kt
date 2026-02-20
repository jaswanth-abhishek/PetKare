package com.example.petkarecopy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener { finish() }
        val btnChangePassword = findViewById<TextView>(R.id.btn_go_change_password)
        btnChangePassword.setOnClickListener {
            startActivity(Intent(this, ChangePasswordActivity::class.java))
        }
        val etName = findViewById<EditText>(R.id.et_edit_name)
        val btnSave = findViewById<TextView>(R.id.btn_save)
        btnSave.setOnClickListener {
            val newName = etName.text.toString().trim()
            if (newName.isEmpty()) {
                Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val prefs = getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
            val token = prefs.getString("authToken", null)
            if (token != null) {
                val request = ProfileUpdateRequest(newName)
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val response = RetrofitClient.instance.updateProfile("Bearer $token", request)
                        withContext(Dispatchers.Main) {
                            if (response.isSuccessful) {
                                Toast.makeText(this@EditProfileActivity, "Profile Updated!", Toast.LENGTH_SHORT).show()
                                finish()
                            } else {
                                Toast.makeText(this@EditProfileActivity, "Failed to update profile", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@EditProfileActivity, "Network Error - Waiting for real URL", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
            else {
                Toast.makeText(this, "Error: Not logged in", Toast.LENGTH_SHORT).show()
            }
        }
    }
}