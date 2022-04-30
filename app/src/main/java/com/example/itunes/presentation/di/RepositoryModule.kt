package com.example.itunes.presentation.di

import com.example.itunes.data.repository.TrackRepositoryImpl
import com.example.itunes.data.repository.datasource.TrackLocalDataSource
import com.example.itunes.data.repository.datasource.TrackRemoteDataSource
import com.example.itunes.domain.repository.TrackRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideTrackRepository(
        moshi: Moshi,
        trackLocalDataSource: TrackLocalDataSource,
        trackRemoteDataSource: TrackRemoteDataSource
    ): TrackRepository = TrackRepositoryImpl(moshi, trackRemoteDataSource, trackLocalDataSource)
}