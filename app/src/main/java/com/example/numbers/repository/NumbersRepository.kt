package com.example.numbers.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.numbers.api.NumbersApi
import com.example.numbers.data.NumberInfo
import com.example.numbers.room.NumberDao
import javax.inject.Inject

class NumbersRepository @Inject constructor(
    private val numberDao: NumberDao,
    private val numbersApi: NumbersApi
) {

    suspend fun updateNumberDetails(number: Int) {

        val str = numbersApi.getNumberDetails(number).filter { !it.isDigit() }
        Log.d("updateNumberDetails" , str)
        insertNumberInDao(number, str)
    }

    fun insertNumberInDao(number: Int, text: String) {
        insertNumberInDao(NumberInfo(number = number, text = text))
    }

    fun insertNumberInDao(numberInfo: NumberInfo) {
        numberDao.insert(numberInfo)
    }

    fun getNumberDetail(number: Int): LiveData<NumberInfo> {
        return numberDao.getInfoAboutNumber(number)
    }

    fun getNumbersHistory(): LiveData<List<NumberInfo>> {
        return numberDao.getNumbersHistory()
    }

    suspend fun getRandomNumber(): NumberInfo {

        val str = numbersApi.getRandomNumberDetails()

        Log.d("getRandomNumber", str)

        return NumberInfo(
            number = str.filter { it.isDigit() }.toInt(),
            text = str.filter { !it.isDigit() })
    }


}