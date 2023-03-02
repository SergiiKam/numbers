package com.example.numbers.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.numbers.data.NumberInfo

@Database(entities = [NumberInfo::class], version = 1)
abstract class DBase : RoomDatabase() {
    abstract fun getDao() : NumberDao
}