package com.example.numbers.fragments.numberHistory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.numbers.R
import com.example.numbers.databinding.FragmentNumbersHistoryBinding
import com.example.numbers.fragments.BaseFragment
import com.example.numbers.fragments.numberDetails.NumberDetails
import com.example.numbers.fragments.numberHistory.adapter.NumbersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NumbersHistory : BaseFragment<FragmentNumbersHistoryBinding>() {

    private lateinit var viewModel: NumbersHistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        setBinding(FragmentNumbersHistoryBinding.inflate(layoutInflater, container, false))

        viewModel = ViewModelProvider(this)[NumbersHistoryViewModel::class.java]

        return getBinding().apply { launchWhenStarted() }.root
    }

    private fun launchWhenStarted() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            val adapter = NumbersAdapter(::onAdapterClick)

            getBinding().recView.adapter = adapter

            viewModel.getNumbersHistory().collect {
                adapter.setNewList(it)
            }

        }
    }

    private fun onAdapterClick(bundle: Bundle) {
        val fragment = NumberDetails()
        fragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_main_fragment, fragment)
            .addToBackStack("add")
            .commit()
    }
}