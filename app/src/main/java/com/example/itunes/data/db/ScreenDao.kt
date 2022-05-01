package com.example.itunes.data.db

import androidx.room.*
import com.example.itunes.data.model.Screen

/**
 * Data Access Object where you can write your SQLite query for Screen table
 */
@Dao
interface ScreenDao {
    @Insert
    suspend fun insertScreen(screen: Screen): Long

    @Query("SELECT * FROM screen")
    suspend fun getScreen(): List<Screen>

    @Query("DELETE FROM SCREEN")
    suspend fun deleteScreen()

    @Transaction
    suspend fun saveScreen(screen: Screen){
        deleteScreen()
        insertScreen(screen)
    }
}