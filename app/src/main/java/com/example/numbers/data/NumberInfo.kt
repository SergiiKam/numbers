package com.example.numbers.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NumberInfo(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val number : Int,
    val text : String
)
