package com.example.numbers.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.numbers.data.NumberInfo

@Dao
interface NumberDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(numbersInfo : NumberInfo)

    @Query("select text from NumberInfo where number = :number")
    fun getInfoAboutNumber(number : Int) : LiveData<String>

    @Query("select * from NumberInfo")
    fun getNumbersHistory() : LiveData<List<NumberInfo>>

}