package com.example.numbers.fragments.numberHistory.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.numbers.R
import com.example.numbers.data.NumberInfo
import com.example.numbers.databinding.FragmentNumberHistoryEntryBinding

abstract class NumberUserViewHolder(binding: FragmentNumberHistoryEntryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        FragmentNumberHistoryEntryBinding.bind(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_number_history_entry, parent, false)
        )
    )
}

class NumbersAdapter(val onAdapterClick: (Bundle) -> Unit) :
    RecyclerView.Adapter<NumbersAdapter.ViewHolder>() {

    class ViewHolder(view: ViewGroup) : NumberUserViewHolder(view)

    private var numberList: List<NumberInfo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.text).text = numberList[position].text
        holder.itemView.findViewById<TextView>(R.id.number).text =
            numberList[position].number.toString()
        holder.itemView.findViewById<LinearLayout>(R.id.recycle_view_element).setOnClickListener {

            val bundle = Bundle()
            bundle.putInt("Number", numberList[position].id!!)

            onAdapterClick(bundle)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewList(list: List<NumberInfo>) {
        numberList = list
        notifyDataSetChanged()
    }

}