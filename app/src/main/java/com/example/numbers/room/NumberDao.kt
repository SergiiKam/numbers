package com.example.numbers.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.numbers.data.NumberInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface NumberDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(numbersInfo: NumberInfo)

    @Query("select * from NumberInfo where id = :id")
    fun getInfoAboutNumber(id: Int): Flow<NumberInfo>

    @Query("select * from NumberInfo order by id desc")
    fun getNumbersHistory(): Flow<List<NumberInfo>>

}