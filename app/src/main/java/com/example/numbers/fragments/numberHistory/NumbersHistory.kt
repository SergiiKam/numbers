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
import com.example.numbers.fragments.BaseFragment
import com.example.numbers.fragments.numberHistory.adapter.NumbersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NumbersHistory : BaseFragment<FragmentNumbersHistoryBinding>() {

    private lateinit var viewModel: NumbersHistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_numbers_history, container, false)

        setBinding(FragmentNumbersHistoryBinding.bind(view))

        viewModel = ViewModelProvider(this)[NumbersHistoryViewModel::class.java]

        val adapter = NumbersAdapter()

        viewModel.getNumbersHistory().observe(viewLifecycleOwner, Observer {

            adapter.setNewList(it)
        })


        getBinding().recView.adapter = adapter

        return getBinding().root
    }
}