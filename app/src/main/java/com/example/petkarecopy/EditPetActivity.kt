package com.example.petkarecopy

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class EditPetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_pet)
        val btnBack = findViewById<ImageView>(R.id.btn_back)
        val btnHeaderSave = findViewById<TextView>(R.id.btn_header_save)
        val btnDelete = findViewById<TextView>(R.id.btn_delete)
        val spinnerType = findViewById<Spinner>(R.id.spinner_type)
        val spinnerGender = findViewById<Spinner>(R.id.spinner_gender)
        val spinnerBreed = findViewById<Spinner>(R.id.spinner_breed)
        val spinnerAge = findViewById<Spinner>(R.id.spinner_age)
        val spinnerNature = findViewById<Spinner>(R.id.spinner_nature)
        val types = arrayOf("Dog", "Cat")
        val genders = arrayOf("Male", "Female", "Others")
        val ages = arrayOf("0", "1", "2", "3", "4", "5", "6")
        val natures = arrayOf("Friendly", "Aggressive", "Playful", "Shy")
        val dogBreeds = arrayOf("Labrador", "German Shepherd", "Golden Retriever", "Bulldog", "Beagle")
        val catBreeds = arrayOf("Persian", "Maine Coon", "Siamese", "Bengal", "Ragdoll")
        setupSpinner(spinnerType, types)
        setupSpinner(spinnerGender, genders)
        setupSpinner(spinnerAge, ages)
        setupSpinner(spinnerNature, natures)
        spinnerType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (types[position] == "Dog") {
                    setupSpinner(spinnerBreed, dogBreeds)
                } else {
                    setupSpinner(spinnerBreed, catBreeds)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        btnBack.setOnClickListener {
            finish()
        }
        btnHeaderSave.setOnClickListener {
            finish()
        }
        btnDelete.setOnClickListener {
            finish()
        }
    }
    private fun setupSpinner(spinner: Spinner, data: Array<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }
}