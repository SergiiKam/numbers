package com.example.numbers.fragments.numberDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.numbers.databinding.FragmentNumberDetailsBinding
import com.example.numbers.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class NumberDetails : BaseFragment<FragmentNumberDetailsBinding>() {

    private lateinit var viewModel: NumberDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //val view = inflater.inflate(R.layout.fragment_number_details, container, false)

        setBinding(FragmentNumberDetailsBinding.inflate(layoutInflater, container, false))

        viewModel = ViewModelProvider(this)[NumberDetailsViewModel::class.java]

        return getBinding().apply {
            launchWhenStarted()
        }.root
    }

    private fun launchWhenStarted() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            val number = arguments?.getInt("Number")
            if (number != null) {
                viewModel.getNumberDetail(number).collectLatest {
                    getBinding().details.text = it.text
                }
            }
        }
    }

}