package com.example.numbers.fragments.numberHistory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.numbers.R
import com.example.numbers.databinding.FragmentNumberHistoryEntryBinding

abstract class NumberUserViewHolder(binding: FragmentNumberHistoryEntryBinding): RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        FragmentNumberHistoryEntryBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.fragment_number_history_entry, parent, false))
    )
}

class NumbersAdapter() : RecyclerView.Adapter<NumbersAdapter.ViewHolder>() {

    class ViewHolder(view : ViewGroup) : NumberUserViewHolder(view)

    private var numberList : List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.text).text = numberList[position]
    }

    fun setNewList(list : List<String>) {
        numberList = list
        notifyDataSetChanged()
    }

}