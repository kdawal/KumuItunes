package com.example.itunes.data.repository.datasource

import com.example.itunes.data.model.LastAccessDate
import com.example.itunes.data.model.Track
import kotlinx.coroutines.flow.Flow

interface TrackLocalDataSource {
    suspend fun saveTrack(track: List<Track>)
    fun getSavedTrack(): Flow<List<Track>>
    suspend fun saveDate(lastAccessDate: LastAccessDate): Long
    suspend fun updateSavedDate(lastAccessDate: LastAccessDate)
    suspend fun getSavedDate(): List<LastAccessDate>

}