package com.example.petkarecopy


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val locationSpinner=findViewById<Spinner>(R.id.spinner_location)
        val petSpinner=findViewById<Spinner>(R.id.spinner_pets)
        val locations=listOf("Home-123 Main St","Work-Tech Park")
        val pets=listOf("Fluffy(Cat)","Max(Dog)")

        val locAdapter=ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, locations)
        val petAdapter=ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, pets)
        locationSpinner.adapter=locAdapter
        petSpinner.adapter=petAdapter

        val btnSearch=findViewById<Button>(R.id.btn_search)
        btnSearch.setOnClickListener {
            val intent=Intent(this, AvailableSittersActivity::class.java)
            startActivity(intent)
        }
        val navProfile=findViewById<View>(R.id.nav_profile_layout)
        navProfile.setOnClickListener {
            val intent=Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}