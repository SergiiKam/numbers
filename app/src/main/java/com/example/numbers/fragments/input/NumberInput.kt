package com.example.numbers.fragments.input

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.numbers.R
import com.example.numbers.databinding.FragmentNumberInputBinding
import com.example.numbers.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NumberInput : BaseFragment<FragmentNumberInputBinding>() {

    private lateinit var viewModel: NumberInputViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_number_input, container, false)
        setBinding(FragmentNumberInputBinding.bind(view))

        viewModel = ViewModelProvider(this)[NumberInputViewModel::class.java]

        getBinding().getNumberDetails.setOnClickListener {

            if (getBinding().inputNumber.text.toString().isNotEmpty()) {

                viewModel.getNumberDetails(getBinding().inputNumber.text.toString().toInt())

            }
        }

        getBinding().getRandomNumberDetails.setOnClickListener {

            viewModel.getRandomInt()

        }

        return getBinding().root
    }

}