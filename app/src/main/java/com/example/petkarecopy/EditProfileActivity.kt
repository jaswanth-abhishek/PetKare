package com.example.petkarecopy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        val btnBack=findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }
        val btnSave=findViewById<TextView>(R.id.btn_save)
        btnSave.setOnClickListener {
            finish()
        }
        val btnChangePassword = findViewById<TextView>(R.id.btn_go_change_password)
        btnChangePassword.setOnClickListener {
            startActivity(Intent(this, ChangePasswordActivity::class.java))
        }
    }
}
