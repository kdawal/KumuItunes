package com.example.itunes.domain.repository

import com.example.itunes.data.model.LastAccessDate
import com.example.itunes.data.model.Screen
import com.example.itunes.data.model.Track
import com.example.itunes.data.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Repository layout where functions needed for implementing use cases found.
 */
interface TrackRepository {
    suspend fun getTracks(): Resource<List<Track>>
    suspend fun saveTrack(track: Track)
    suspend fun getSavedTrack(): Resource<Track>
    suspend fun saveDate(lastAccessDate: LastAccessDate): Resource<Boolean>
    suspend fun getSaveDate(): Resource<LastAccessDate>
    suspend fun saveScreen(screen: Screen): Resource<Boolean>
    suspend fun getSavedScreen(): Resource<Screen>
}