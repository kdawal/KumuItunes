package com.example.itunes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

@Entity(tableName = "date_access")
data class LastAccessDate (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val date: String
    )