package com.example.numbers.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.numbers.data.NumberInfo

@Dao
interface NumberDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(numbersInfo : NumberInfo)

    @Query("select text from NumberInfo where id = :number")
    fun getInfoAboutNumber(number : Int) : LiveData<String>

    @Query("select text from NumberInfo")
    fun getNumbersHistory() : LiveData<List<String>>

}