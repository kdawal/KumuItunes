package com.example.itunes.data.db

import androidx.room.*
import com.example.itunes.data.model.LastAccessDate

/**
 * Data Access Object where you can write your SQLite query for Date table
 */
@Dao
interface DateAccessDao {
    @Insert
    suspend fun insertDate(lastAccessDate: LastAccessDate): Long

    @Query("SELECT * FROM date_access")
    suspend fun getSaveDate(): List<LastAccessDate>

    @Query("DELETE FROM date_access")
    suspend fun deleteDate()

    @Transaction
    suspend fun saveDate(lastAccessDate: LastAccessDate){
        deleteDate()
        insertDate(lastAccessDate)
    }


}