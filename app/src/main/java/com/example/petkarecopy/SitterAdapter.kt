package com.example.petkarecopy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Sitter(
    val name: String,
    val specialty: String,
    val distance: String,
    val price: String,
    val rating: String
)
class SitterAdapter(
    private val sitterList: List<Sitter>,
    private val onBookClick: (Sitter) -> Unit,
    private val onCardClick: (Sitter) -> Unit
) : RecyclerView.Adapter<SitterAdapter.SitterViewHolder>() {
    class SitterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_sitter_name)
        val tvRating: TextView = view.findViewById(R.id.tv_sitter_rating)
        val tvSubtitle: TextView = view.findViewById(R.id.tv_sitter_subtitle)
        val tvPrice: TextView = view.findViewById(R.id.tv_sitter_price)
        val btnBookNow: Button = view.findViewById(R.id.btn_book_now)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SitterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sitter, parent, false)
        return SitterViewHolder(view)
    }
    override fun onBindViewHolder(holder: SitterViewHolder, position: Int) {
        val sitter = sitterList[position]
        holder.tvName.text = sitter.name
        holder.tvRating.text = sitter.rating
        holder.tvSubtitle.text = "${sitter.specialty} • ${sitter.distance}"
        holder.tvPrice.text = sitter.price
        holder.btnBookNow.setOnClickListener { onBookClick(sitter) }
        holder.itemView.setOnClickListener { onCardClick(sitter) }
    }
    override fun getItemCount() = sitterList.size
}