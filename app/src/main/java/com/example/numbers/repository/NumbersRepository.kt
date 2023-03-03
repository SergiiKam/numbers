package com.example.numbers.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.numbers.api.NumbersApi
import com.example.numbers.data.NumberInfo
import com.example.numbers.room.NumberDao
import javax.inject.Inject

class NumbersRepository @Inject constructor(
    private val numberDao: NumberDao,
    private val numbersApi : NumbersApi
){

    suspend fun updateNumberDetails(number : Int) {

        val details = numbersApi.getNumberDetails(number)

        Log.d("details", details)

        numberDao.insert(NumberInfo(number, details))

    }

    fun getNumberDetail(number : Int) : LiveData<String> {
        return numberDao.getInfoAboutNumber(number)
    }

    fun getNumbersHistory() : LiveData<List<String>> {
        return numberDao.getNumbersHistory()
    }



}