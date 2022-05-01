package com.example.itunes.data.model

import androidx.annotation.IdRes
import androidx.room.Entity
import androidx.room.PrimaryKey
/**
 * Data model for Screen table
 */
@Entity(tableName = "screen")
data class Screen(
    @IdRes
    @PrimaryKey
    val id: Int

)