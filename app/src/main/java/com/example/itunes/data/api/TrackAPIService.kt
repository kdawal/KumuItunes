package com.example.itunes.data.api

import com.example.itunes.data.model.BaseResponse
import com.example.itunes.data.model.Track
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
/**
 * A Retrofit service for fetching data from the server.
 */
interface TrackAPIService {
    @GET("/search")
    suspend fun getTracks(
        @Query("term")
        term: String?= "star",
        @Query("amp:country")
        country: String? = "au",
        @Query("amp:media")
        media: String? = "movie",
        @Query("amp:all")
        all: String? = "",
    ): Response<BaseResponse<List<Track>>>
}