package com.example.numbers.fragments.numberHistory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.numbers.R
import com.example.numbers.databinding.FragmentNumberHistoryEntryBinding

abstract class ItemUserViewHolder(binding: FragmentNumberHistoryEntryBinding): RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        FragmentNumberHistoryEntryBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.fragment_number_history_entry, parent, false))
    )
}

class NumbersAdapter() : RecyclerView.Adapter<NumbersAdapter.ViewHolder>() {

    class ViewHolder(view : ViewGroup) : ItemUserViewHolder(view)

    private var numberList : List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.
    }

    fun setNewList(list : List<String>) {
        numberList = list
        notifyDataSetChanged()
    }

}