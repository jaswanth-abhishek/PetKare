package com.example.petkarecopy

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AvailableSittersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_available_sitters)
        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }
        val rvSitters = findViewById<RecyclerView>(R.id.rv_sitters)
        rvSitters.layoutManager = LinearLayoutManager(this)
        val sitterList = listOf(
            Sitter(
                name = "Sarah Jenkins",
                specialty = "Dog Specialist",
                distance = "2km away",
                price = "$25 / day",
                rating = "4.9"
            ),
            Sitter(
                name = "Mike Ross",
                specialty = "Large Backyard",
                distance = "5km away",
                price = "$20 / day",
                rating = "4.7"
            )
        )
        val adapter = SitterAdapter(
            sitterList = sitterList,
            onBookClick = { selectedSitter ->
                Toast.makeText(
                    this,
                    "Starting booking for ${selectedSitter.name}...",
                    Toast.LENGTH_SHORT
                ).show()
            },
            onCardClick = { selectedSitter ->
                Toast.makeText(
                    this,
                    "Viewing profile of ${selectedSitter.name}",
                    Toast.LENGTH_SHORT
                ).show()
                // future lo use avuthundhi
                // val intent = Intent(this, SitterProfileActivity::class.java)
                // intent.putExtra("SITTER_NAME", selectedSitter.name)
                // startActivity(intent)
            }
        )
        rvSitters.adapter = adapter
    }
}