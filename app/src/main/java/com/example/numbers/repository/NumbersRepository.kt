package com.example.numbers.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.numbers.api.NumbersApi
import com.example.numbers.data.NumberInfo
import com.example.numbers.room.NumberDao
import kotlinx.coroutines.CoroutineScope
import java.awt.font.TextAttribute
import javax.inject.Inject

class NumbersRepository @Inject constructor(
    private val numberDao: NumberDao,
    private val numbersApi : NumbersApi
){

    suspend fun updateNumberDetails(number : Int) {
        insertNumberInDao(number, numbersApi.getNumberDetails(number).filter { !it.isDigit() })
    }

    suspend fun insertNumberInDao(number : Int, text : String){
        insertNumberInDao(NumberInfo(number = number, text = text))
    }

    suspend fun insertNumberInDao(numberInfo: NumberInfo) {
        numberDao.insert(numberInfo)
    }

    fun getNumberDetail(number : Int) : LiveData<String> {
        return numberDao.getInfoAboutNumber(number)
    }

    fun getNumbersHistory() : LiveData<List<NumberInfo>> {
        return numberDao.getNumbersHistory()
    }

    suspend fun getRandomNumber() : NumberInfo {

        val str = numbersApi.getRandomNumberDetails()

        return NumberInfo(number = str.filter { it.isDigit() }.toInt(), text = str.filter { !it.isDigit() })
    }


}