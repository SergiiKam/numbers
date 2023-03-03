package com.example.numbers.fragments.numberHistory

import androidx.lifecycle.ViewModel
import com.example.numbers.repository.NumbersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NumbersHistoryViewModel @Inject constructor(
    private val numbersRepository: NumbersRepository
): ViewModel() {

    fun getNumbersHistory() = numbersRepository.getNumbersHistory()

}