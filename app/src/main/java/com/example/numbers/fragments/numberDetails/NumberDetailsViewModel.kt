package com.example.numbers.fragments.numberDetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.numbers.api.SingletonRetrofit
import com.example.numbers.room.NumberDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NumberDetailsViewModel @Inject constructor(
    private val numberDao: NumberDao
): ViewModel() {

    fun getNumberDetail(number : Int) : LiveData<String> {
        return numberDao.getInfoAboutNumber(number)
    }


}