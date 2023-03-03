package com.example.numbers.fragments.input

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.numbers.R
import com.example.numbers.databinding.FragmentNumberInputBinding
import com.example.numbers.databinding.FragmentNumbersHistoryBinding
import com.example.numbers.fragments.BaseFragment
import com.example.numbers.fragments.numberDetails.NumberDetails
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NumberInput : BaseFragment<FragmentNumberInputBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_number_input, container, false)

        setBinding(FragmentNumberInputBinding.bind(view))

        getBinding().getNumberDetails.setOnClickListener {

            if (getBinding().inputNumber.text.toString().isNotEmpty()) {

                val bundle : Bundle = Bundle()
                bundle.putInt("Number", getBinding().inputNumber.text.toString().toInt())

                val fragment = NumberDetails()
                fragment.arguments = bundle

                parentFragmentManager.beginTransaction()
                    .replace(R.id.activity_main_fragment, fragment)
                    .addToBackStack("add")
                    .commit()

            }
        }

        return getBinding().root
    }
}