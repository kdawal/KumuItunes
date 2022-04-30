package com.example.itunes.data.repository

import com.example.itunes.data.model.LastAccessDate
import com.example.itunes.data.model.Track
import com.example.itunes.data.repository.datasource.TrackLocalDataSource
import com.example.itunes.data.repository.datasource.TrackRemoteDataSource
import com.example.itunes.data.util.Resource
import com.example.itunes.data.util.evaluateCall
import com.example.itunes.domain.repository.TrackRepository
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.Flow
import java.lang.Exception

class TrackRepositoryImpl(
    private val moshi: Moshi,
    private val trackRemoteDataSource: TrackRemoteDataSource,
    private val trackLocalDataSource: TrackLocalDataSource
): TrackRepository {
    override suspend fun getTracks(): Resource<List<Track>> {
        return evaluateCall(moshi){trackRemoteDataSource.getTracks()}
    }

    override fun getSaveTracks(): Flow<List<Track>> {
        return trackLocalDataSource.getSavedTrack()
    }

    override suspend fun saveDate(lastAccessDate: LastAccessDate): Resource<Boolean> {
        return try {
            trackLocalDataSource.saveDate(lastAccessDate)
            Resource.Success(true)
        } catch (e: Exception){
            Resource.Error(e.message)
        }
    }

    override suspend fun updateDate(lastAccessDate: LastAccessDate): Resource<Boolean> {
        return try{
            trackLocalDataSource.updateSavedDate(lastAccessDate)
            Resource.Success(true)
        }catch (e: Exception){
            Resource.Error(e.message)
        }
    }

    override suspend fun getSaveDate(): Resource<LastAccessDate> {
        return try {
            val result = trackLocalDataSource.getSavedDate().first()
            Resource.Success(result)
        }catch (e: Exception){
            Resource.Error(e.message)
        }
    }
}