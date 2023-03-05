package com.example.numbers.fragments.numberDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.numbers.R
import com.example.numbers.databinding.FragmentNumberDetailsBinding
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

        val number = arguments?.getInt("Number")

        if (number != null) {
            viewModel.getNumberDetail(number).observe(viewLifecycleOwner) {
                getBinding().details.text = String.format( view.resources.getString(R.string.details_info), it.number, it.text )
            }
        }

        return getBinding().root
    }

}