package com.example.petkarecopy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
data class Address(val title: String, val details: String, val type: String)

class AddressAdapter(
    private val addressList: List<Address>,
    private val onClick: (Address) -> Unit
) : RecyclerView.Adapter<AddressAdapter.AddressViewHolder>() {
    class AddressViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivIcon: ImageView = view.findViewById(R.id.iv_address_icon)
        val tvTitle: TextView = view.findViewById(R.id.tv_address_title)
        val tvDetail: TextView = view.findViewById(R.id.tv_address_detail)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_address, parent, false)
        return AddressViewHolder(view)
    }
    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val address = addressList[position]
        holder.tvTitle.text = address.title
        holder.tvDetail.text = address.details
        if (address.type == "Home") {
            holder.ivIcon.setImageResource(R.drawable.home)
        } else {
            holder.ivIcon.setImageResource(R.drawable.work)
        }
        holder.itemView.setOnClickListener { onClick(address) }
    }
    override fun getItemCount() = addressList.size
}