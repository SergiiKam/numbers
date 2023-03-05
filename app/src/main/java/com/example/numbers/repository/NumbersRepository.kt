package com.example.numbers.repository

import android.util.Log
import com.example.numbers.api.NumbersApi
import com.example.numbers.data.NumberInfo
import com.example.numbers.room.NumberDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NumbersRepository @Inject constructor(
    private val numberDao: NumberDao,
    private val numbersApi: NumbersApi
) {

    suspend fun updateNumberDetails(number: Int) {

        val str = numbersApi.getNumberDetails(number).filter { !it.isDigit() }
        Log.d("updateNumberDetails", str)
        insertNumberInDao(number, str)
    }

    private fun insertNumberInDao(number: Int, text: String) {
        insertNumberInDao(NumberInfo(number = number, text = text))
    }

    private fun insertNumberInDao(numberInfo: NumberInfo) {
        numberDao.insert(numberInfo)
    }

    fun getNumberDetail(number: Int): Flow<NumberInfo> {
        return numberDao.getInfoAboutNumber(number)
    }

    fun getNumbersHistory(): Flow<List<NumberInfo>> {
        return numberDao.getNumbersHistory()
    }

    suspend fun getAndUpdateRandomNumber() = insertNumberInDao(getRandomNumber())

    private suspend fun getRandomNumber(): NumberInfo {

        val str = numbersApi.getRandomNumberDetails()

        Log.d("getRandomNumber", str)

        return NumberInfo(
            number = str.filter { it.isDigit() }.toInt(),
            text = str.filter { !it.isDigit() })
    }


}