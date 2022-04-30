package com.example.itunes.data.repository.datasourceimpl

import com.example.itunes.data.api.TrackAPIService
import com.example.itunes.data.model.BaseResponse
import com.example.itunes.data.model.Track
import com.example.itunes.data.repository.datasource.TrackRemoteDataSource
import retrofit2.Response

class TrackRemoteDatasourceImpl(
    private val trackAPIService: TrackAPIService
): TrackRemoteDataSource {
    override suspend fun getTracks(): Response<BaseResponse<List<Track>>> {
        return trackAPIService.getTracks()
    }
}