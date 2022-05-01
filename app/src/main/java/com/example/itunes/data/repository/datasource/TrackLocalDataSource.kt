package com.example.itunes.data.repository.datasource

import com.example.itunes.data.model.LastAccessDate
import com.example.itunes.data.model.Screen
import com.example.itunes.data.model.Track
import kotlinx.coroutines.flow.Flow
/**
 * Data source use for interacting with the local database (DAO)
 */
interface TrackLocalDataSource {
    suspend fun saveTrack(track: Track)
    suspend fun getSavedTrack(): List<Track>
    suspend fun saveDate(lastAccessDate: LastAccessDate)
    suspend fun getSavedDate(): List<LastAccessDate>
    suspend fun saveScreen(screen: Screen)
    suspend fun getSavedScreen(): List<Screen>

}