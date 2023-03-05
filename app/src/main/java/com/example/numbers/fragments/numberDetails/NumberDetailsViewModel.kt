package com.example.numbers.fragments.numberDetails

import androidx.lifecycle.ViewModel
import com.example.numbers.data.NumberInfo
import com.example.numbers.repository.NumbersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class NumberDetailsViewModel @Inject constructor(
    private val numbersRepository: NumbersRepository
) : ViewModel() {

    fun getNumberDetail(number: Int): Flow<NumberInfo> {
        return numbersRepository.getNumberDetail(number)
    }

}