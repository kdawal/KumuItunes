package com.example.itunes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

/**
 * Data model for Last Access Date table
 */
@JsonClass(generateAdapter = true)
@Entity(tableName = "date_access")
data class LastAccessDate(
    @PrimaryKey
    val date: String,
)