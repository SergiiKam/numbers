package com.example.numbers.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NumberInfo(
    @PrimaryKey
    val id : Int,
    val text : String
)
