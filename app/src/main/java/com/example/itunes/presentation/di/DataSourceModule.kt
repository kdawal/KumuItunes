package com.example.itunes.presentation.di

import com.example.itunes.data.api.TrackAPIService
import com.example.itunes.data.db.DateAccessDao
import com.example.itunes.data.db.ScreenDao
import com.example.itunes.data.db.TrackDao
import com.example.itunes.data.repository.datasource.TrackLocalDataSource
import com.example.itunes.data.repository.datasource.TrackRemoteDataSource
import com.example.itunes.data.repository.datasourceimpl.TrackLocalDataSourceImpl
import com.example.itunes.data.repository.datasourceimpl.TrackRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dependency injection for data sources
 */
@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideTrackRemoteDataSource(
        trackAPIService: TrackAPIService
    ): TrackRemoteDataSource = TrackRemoteDatasourceImpl(trackAPIService)

    @Singleton
    @Provides
    fun provideTrackLocalDatSource(
        trackDao: TrackDao,
        dateAccessDao: DateAccessDao,
        screenDao: ScreenDao
    ): TrackLocalDataSource = TrackLocalDataSourceImpl(dateAccessDao, trackDao, screenDao)
}