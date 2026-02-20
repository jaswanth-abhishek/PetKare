package com.example.petkarecopy

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val btnResetPassword = findViewById<Button>(R.id.btn_reset_password)
        btnResetPassword.setOnClickListener {
            Toast.makeText(this, "Password reset link sent!", Toast.LENGTH_SHORT).show()
            finish()
        }

        val tvBackToLogin = findViewById<TextView>(R.id.tv_back_to_login)
        tvBackToLogin.setOnClickListener {
            finish()
        }
    }
}