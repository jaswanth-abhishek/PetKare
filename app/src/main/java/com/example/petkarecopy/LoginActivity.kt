package com.example.petkarecopy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        findViewById<Button>(R.id.btn_login).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
        findViewById<TextView>(R.id.tv_create_account).setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
 }