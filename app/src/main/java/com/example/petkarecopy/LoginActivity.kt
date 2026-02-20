package com.example.petkarecopy

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.petkarecopy.SignupActivity

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Login -> Home
        findViewById<Button>(R.id.btn_login).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        // Create Account -> SignupActivity
        findViewById<TextView>(R.id.tv_create_account).setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        findViewById<TextView>(R.id.tv_forgot_pass).setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }
 }