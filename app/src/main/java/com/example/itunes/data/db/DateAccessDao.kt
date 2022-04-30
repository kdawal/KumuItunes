package com.example.itunes.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.itunes.data.model.LastAccessDate

@Dao
interface DateAccessDao {
    @Insert
    suspend fun save(lastAccessDate: LastAccessDate): Long

    @Update
    suspend fun update(lastAccessDate: LastAccessDate)

    @Query("SELECT * FROM date_access")
    suspend fun getSaveDate(): List<LastAccessDate>

}