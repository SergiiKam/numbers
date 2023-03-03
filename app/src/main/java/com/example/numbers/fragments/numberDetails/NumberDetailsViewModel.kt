package com.example.numbers.fragments.numberDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.numbers.repository.NumbersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NumberDetailsViewModel @Inject constructor(
    private val numbersRepository: NumbersRepository
): ViewModel() {

    fun getNumberDetail(number : Int) : LiveData<String> {
        viewModelScope.launch(Dispatchers.IO) {
            numbersRepository.updateNumberDetails(number)
        }

        return numbersRepository.getNumberDetail(number)
    }

}