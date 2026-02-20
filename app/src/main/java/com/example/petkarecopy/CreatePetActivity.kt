package com.example.petkarecopy

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CreatePetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_pet)

        // View Binding
        val btnBack = findViewById<ImageView>(R.id.btn_back)
        val btnHeaderSave = findViewById<TextView>(R.id.btn_header_save)
        val btnSavePet = findViewById<TextView>(R.id.btn_save_pet)

        val spinnerType = findViewById<Spinner>(R.id.spinner_type)
        val spinnerGender = findViewById<Spinner>(R.id.spinner_gender)
        val spinnerBreed = findViewById<Spinner>(R.id.spinner_breed)
        val spinnerAge = findViewById<Spinner>(R.id.spinner_age)
        val spinnerNature = findViewById<Spinner>(R.id.spinner_nature)

        // 1. Data Lists
        val types = arrayOf("Dog", "Cat")
        val genders = arrayOf("Male", "Female", "Others")
        val ages = arrayOf("0", "1", "2", "3", "4", "5", "6")
        val natures = arrayOf("Friendly", "Aggressive", "Playful", "Shy")

        val dogBreeds = arrayOf("Labrador", "German Shepherd", "Golden Retriever", "Bulldog", "Beagle")
        val catBreeds = arrayOf("Persian", "Maine Coon", "Siamese", "Bengal", "Ragdoll")

        // 2. Set Simple Adapters
        setupSpinner(spinnerType, types)
        setupSpinner(spinnerGender, genders)
        setupSpinner(spinnerAge, ages)
        setupSpinner(spinnerNature, natures)

        // 3. Dynamic Breed Selection Logic
        spinnerType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedType = types[position]
                if (selectedType == "Dog") {
                    setupSpinner(spinnerBreed, dogBreeds)
                } else {
                    setupSpinner(spinnerBreed, catBreeds)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Clicks
        btnBack.setOnClickListener { finish() }
        btnHeaderSave.setOnClickListener { finish() }
        btnSavePet.setOnClickListener { finish() }
    }

    private fun setupSpinner(spinner: Spinner, data: Array<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }
}