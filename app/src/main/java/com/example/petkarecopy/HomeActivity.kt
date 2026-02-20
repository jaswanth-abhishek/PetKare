package com.example.petkarecopy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupBottomNavigation()
        setupSearchButton()
        loadUserLocations()
        loadUserPets()
    }
    private fun loadUserLocations() {
        val locationSpinner = findViewById<Spinner>(R.id.spinner_location)
        val locations = listOf("Select Location...", "Home - 123 Main St", "Work - Tech Park")
        val locAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, locations)
        locationSpinner.adapter = locAdapter
    }
    private fun loadUserPets() {
        val petSpinner = findViewById<Spinner>(R.id.spinner_pets)
        val pets = listOf("Select Pet...", "Fluffy (Cat)", "Max (Dog)")
        val petAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, pets)
        petSpinner.adapter = petAdapter
    }
    private fun setupSearchButton() {
        findViewById<Button>(R.id.btn_search).setOnClickListener {
            startActivity(Intent(this, AvailableSittersActivity::class.java))
        }
    }
    private fun setupBottomNavigation() {
        findViewById<View>(R.id.nav_profile).setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

        // Add nav_bookings here when ready
    }
}