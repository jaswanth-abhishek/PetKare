package com.example.petkarecopy

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChangePasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        findViewById<ImageView>(R.id.btn_back).setOnClickListener { finish() }
        val etNewPassword = findViewById<EditText>(R.id.et_new_password)
        findViewById<Button>(R.id.btn_save_password).setOnClickListener {
            val newPass = etNewPassword.text.toString().trim()
            if (newPass.isEmpty()) {
                Toast.makeText(this, "Please enter a new password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val prefs = getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
            val token = prefs.getString("authToken", null)
            if (token != null) {
                val request = PasswordChangeRequest(newPass)
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val response = RetrofitClient.instance.changePassword("Bearer $token", request)
                        withContext(Dispatchers.Main) {
                            if (response.isSuccessful) {
                                Toast.makeText(this@ChangePasswordActivity, "Password Updated!", Toast.LENGTH_SHORT).show()
                                finish()
                            }
                            else {
                                Toast.makeText(this@ChangePasswordActivity, "Failed to update", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@ChangePasswordActivity, "Network Error - Waiting for real URL", Toast.LENGTH_SHORT).show()
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