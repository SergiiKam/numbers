package com.example.numbers.fragments.numberDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.numbers.R
import com.example.numbers.databinding.FragmentNumberDetailsBinding
import com.example.numbers.databinding.FragmentNumbersHistoryBinding
import com.example.numbers.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NumberDetails : BaseFragment<FragmentNumberDetailsBinding>() {

    private lateinit var viewModel: NumberDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_number_details, container, false)

        setBinding(FragmentNumberDetailsBinding.bind(view))

        viewModel = ViewModelProvider(this)[NumberDetailsViewModel::class.java]

        viewModel.getNumberDetail(arguments?.getInt("Number")!!).observe(viewLifecycleOwner, Observer {
            getBinding().details.text = it
        })

        return getBinding().root
    }

}