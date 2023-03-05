package com.example.numbers.fragments.input

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.numbers.R
import com.example.numbers.repository.NumbersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NumberInputViewModel @Inject constructor(
    private val numbersRepository: NumbersRepository
): ViewModel() {

    fun getNumberDetails(number : Int) {
        viewModelScope.launch(Dispatchers.IO) {
            numbersRepository.updateNumberDetails(number)
        }
    }

    fun getRandomInt() {

        viewModelScope.launch(Dispatchers.IO) {

            val numberInfo = numbersRepository.getRandomNumber()
            numbersRepository.insertNumberInDao(numberInfo)
        }

    }

}