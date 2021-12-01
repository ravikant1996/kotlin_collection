package com.example.lifecycleaware.DiffUtills

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecycleaware.R

class ProgrammingAdapter : ListAdapter<ProgramItems,
        ProgrammingAdapter.ProgrammingViewHolder>(ProgrammingViewHolder.DiffUtils()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        val items = getItem(position)
        holder.bind(items)
    }

    class ProgrammingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById<TextView>(R.id.name)
        val initial: TextView = view.findViewById<TextView>(R.id.initial)

        fun bind(items: ProgramItems) {
            name.text = items.name
            initial.text = items.initial
        }

        class DiffUtils() : DiffUtil.ItemCallback<ProgramItems>() {
            override fun areItemsTheSame(oldItem: ProgramItems, newItem: ProgramItems): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ProgramItems, newItem: ProgramItems): Boolean {
                return oldItem == newItem
            }
        }
    }


}