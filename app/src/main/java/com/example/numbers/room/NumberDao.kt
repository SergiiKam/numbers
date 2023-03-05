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

    @Query("select * from NumberInfo where id = :id")
    fun getInfoAboutNumber(id : Int) : LiveData<NumberInfo>

    @Query("select * from NumberInfo")
    fun getNumbersHistory() : LiveData<List<NumberInfo>>

}