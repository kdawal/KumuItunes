package com.example.itunes.data.repository

import android.util.Log
import com.example.itunes.data.model.LastAccessDate
import com.example.itunes.data.model.Screen
import com.example.itunes.data.model.Track
import com.example.itunes.data.repository.datasource.TrackLocalDataSource
import com.example.itunes.data.repository.datasource.TrackRemoteDataSource
import com.example.itunes.data.util.Resource
import com.example.itunes.data.util.evaluateCall
import com.example.itunes.domain.repository.TrackRepository
import java.lang.Exception

/**
 * A repository which handles all the data from local and api
 *
 * Uses a function for better error handling
 */
class TrackRepositoryImpl(
    private val trackRemoteDataSource: TrackRemoteDataSource,
    private val trackLocalDataSource: TrackLocalDataSource
): TrackRepository {
    override suspend fun getTracks(): Resource<List<Track>> {

        return evaluateCall{trackRemoteDataSource.getTracks()}
    }

    override suspend fun saveTrack(track: Track) {
        trackLocalDataSource.saveTrack(track)
    }

    override suspend fun getSavedTrack(): Resource<Track> {
        return try {
            val result = trackLocalDataSource.getSavedTrack().first()
            Resource.Success(result)
        }catch (e: Exception){
            Log.e("Error",e.message.toString())
            Resource.Error(e.message)
        }
    }

    override suspend fun saveDate(lastAccessDate: LastAccessDate): Resource<Boolean> {
        return try {
            trackLocalDataSource.saveDate(lastAccessDate)
            Resource.Success(true)
        } catch (e: Exception){
            Log.e("Error",e.message.toString())
            Resource.Error(e.message)
        }
    }

    override suspend fun getSaveDate(): Resource<LastAccessDate> {
        return try {
            val result = trackLocalDataSource.getSavedDate().first()
            Resource.Success(result)
        }catch (e: Exception){
            Log.e("Error",e.message.toString())
            Resource.Error(e.message)
        }
    }

    override suspend fun saveScreen(screen: Screen): Resource<Boolean> {
        return try{
            trackLocalDataSource.saveScreen(screen)
            Resource.Success(true)
        }catch (e: Exception){
            Log.e("Error",e.message.toString())
            Resource.Error(e.message)
        }
    }

    override suspend fun getSavedScreen(): Resource<Screen> {
        return try{
            val result = trackLocalDataSource.getSavedScreen().firstOrNull()
            Resource.Success(result)
        }catch (e: Exception){
            Log.e("Error",e.message.toString())
            Resource.Error(e.message)
        }
    }

}