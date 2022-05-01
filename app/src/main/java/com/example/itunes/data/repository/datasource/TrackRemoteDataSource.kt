package com.example.itunes.data.repository.datasource

import com.example.itunes.data.model.BaseResponse
import com.example.itunes.data.model.Track
import retrofit2.Response

/**
 * Datasource for interacting with Retrofit API calls
 */
interface TrackRemoteDataSource {
    suspend fun getTracks(): Response<BaseResponse<List<Track>>>
}