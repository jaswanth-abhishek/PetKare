package com.example.petkarecopy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
data class Pet(
    val name: String,
    val type: String,
    val breed: String,
    val age: String
)
class PetAdapter(
    private val petList: List<Pet>,
    private val onClick: (Pet) -> Unit
) : RecyclerView.Adapter<PetAdapter.PetViewHolder>() {
    class PetViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivPetImage: ImageView = view.findViewById(R.id.iv_pet_image)
        val tvName: TextView = view.findViewById(R.id.tv_pet_name)
        val tvDetails: TextView = view.findViewById(R.id.tv_pet_details)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pet, parent, false)
        return PetViewHolder(view)
    }
    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val pet = petList[position]
        holder.tvName.text = pet.name
        holder.tvDetails.text = "${pet.type} • ${pet.breed}"
        if (pet.type == "Dog") {
            holder.ivPetImage.setImageResource(android.R.drawable.ic_menu_gallery)
        } else {
            holder.ivPetImage.setImageResource(android.R.drawable.ic_menu_gallery)
        }
        holder.itemView.setOnClickListener { onClick(pet) }
    }
    override fun getItemCount() = petList.size
}