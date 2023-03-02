package com.example.numbers.fragments.numberDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.numbers.R
import com.example.numbers.databinding.FragmentNumberDetailsBinding

class NumberDetails : Fragment() {

    private lateinit var viewModel: NumberDetailsViewModel
    private lateinit var binding: FragmentNumberDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentNumberDetailsBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[NumberDetailsViewModel::class.java]

        binding.details.text = viewModel.getNumberDetail(arguments?.getInt("Number")!!)

        return binding.root
    }

}