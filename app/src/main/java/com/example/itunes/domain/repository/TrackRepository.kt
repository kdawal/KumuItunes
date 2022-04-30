package com.example.itunes.domain.repository

import com.example.itunes.data.model.LastAccessDate
import com.example.itunes.data.model.Track
import com.example.itunes.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface TrackRepository {
    suspend fun getTracks(): Resource<List<Track>>
    fun getSaveTracks(): Flow<List<Track>>
    suspend fun saveDate(lastAccessDate: LastAccessDate): Resource<Boolean>
    suspend fun updateDate(lastAccessDate: LastAccessDate): Resource<Boolean>
    suspend fun getSaveDate(): Resource<LastAccessDate>
}