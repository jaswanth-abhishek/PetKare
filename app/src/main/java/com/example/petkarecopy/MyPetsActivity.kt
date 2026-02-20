package com.example.petkarecopy

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyPetsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_pets)
        findViewById<ImageView>(R.id.btn_back).setOnClickListener { finish() }
        findViewById<ImageView>(R.id.btn_add_pet).setOnClickListener {
            startActivity(Intent(this, CreatePetActivity::class.java))
        }
        val rvPets = findViewById<RecyclerView>(R.id.rv_pets)
        rvPets.layoutManager = GridLayoutManager(this, 2)
        val myPetsList = listOf(
            Pet("Fluffy", "Cat", "Persian", "2"),
            Pet("Max", "Dog", "Labrador", "3")
        )
        val adapter = PetAdapter(myPetsList) { selectedPet ->
            val intent = Intent(this, EditPetActivity::class.java)
            startActivity(intent)
        }
        rvPets.adapter = adapter
    }
}