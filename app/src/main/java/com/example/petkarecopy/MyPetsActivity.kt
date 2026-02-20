package com.example.petkarecopy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MyPetsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_pets)
        val btnBack=findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }

        val btnAdd=findViewById<ImageView>(R.id.btn_add)
        btnAdd.setOnClickListener {
            val intent=Intent(this, CreatePetActivity::class.java)
            startActivity(intent)
        }
        val cardPet1=findViewById<LinearLayout>(R.id.card_pet_1)
        cardPet1.setOnClickListener {
            val intent=Intent(this, EditPetActivity::class.java)
            startActivity(intent)
        }
        val cardPet2=findViewById<LinearLayout>(R.id.card_pet_2)
        cardPet2.setOnClickListener {
            val intent = Intent(this, EditPetActivity::class.java)
            startActivity(intent)
        }
    }
}