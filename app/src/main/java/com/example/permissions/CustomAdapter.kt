package com.example.permissions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val contacts: MutableList<Contact>) :
    RecyclerView.Adapter<CustomAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTV: TextView = itemView.findViewById(R.id.nameTV)
        val phoneTV: TextView = itemView.findViewById(R.id.phoneTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate((R.layout.list_item), parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount() = contacts.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = contacts[position]
        holder.nameTV.text = item.name
        holder.phoneTV.text = item.phone
    }
}