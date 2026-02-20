package com.example.petkarecopy

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

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        val etResetEmail=findViewById<EditText>(R.id.et_reset_email)
        findViewById<Button>(R.id.btn_reset_password).setOnClickListener{
            val email=etResetEmail.text.toString().trim()
            if (email.isEmpty()){
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val request=ForgotPasswordRequest(email)
            CoroutineScope(Dispatchers.IO).launch{
                try{
                    val response = RetrofitClient.instance.forgotPassword(request)
                    if (response.isSuccessful) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@ForgotPasswordActivity, "Reset link sent!", Toast.LENGTH_LONG).show()
                            finish()
                        }
                    }
                    else{
                        withContext(Dispatchers.Main){
                            Toast.makeText(this@ForgotPasswordActivity, "Failed to send link", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                catch(e: Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@ForgotPasswordActivity, "Network Error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        findViewById<TextView>(R.id.tv_back_to_login).setOnClickListener{
            finish()
        }
    }
}