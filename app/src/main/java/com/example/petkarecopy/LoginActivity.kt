package com.example.petkarecopy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPassword = findViewById<EditText>(R.id.et_password)
        findViewById<Button>(R.id.btn_login).setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val request = LoginRequest(email, password)
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val response = RetrofitClient.instance.login(request)
                    if (response.isSuccessful && response.body() != null) {
                        val token = response.body()!!.auth.idToken
                        val prefs = getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
                        prefs.edit().putString("authToken", token).apply()
                        withContext(Dispatchers.Main) {
                            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                            finish()
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@LoginActivity, "Login Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@LoginActivity, "Network Error - Waiting for real URL", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        findViewById<TextView>(R.id.tv_create_account).setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
        findViewById<TextView>(R.id.tv_forgot_pass).setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }
}