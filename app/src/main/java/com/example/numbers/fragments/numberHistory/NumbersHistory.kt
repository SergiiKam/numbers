package com.example.numbers.fragments.numberHistory

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.numbers.R
import com.example.numbers.databinding.FragmentNumbersHistoryBinding
import com.example.numbers.fragments.numberHistory.adapter.NumbersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NumbersHistory : Fragment() {

    private lateinit var binding: FragmentNumbersHistoryBinding
    private lateinit var viewModel: NumbersHistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentNumbersHistoryBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(NumbersHistoryViewModel::class.java)

        viewModel.getNumbersHistory().observe(viewLifecycleOwner, Observer {

            it.forEach { element ->
                Log.d("history", element)
            }
        })

        val adapter = NumbersAdapter()
        //binding.rec_view = adapter

        return binding.root
    }
}