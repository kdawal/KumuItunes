package com.example.itunes.presentation.di

import com.example.itunes.domain.repository.TrackRepository
import com.example.itunes.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dependency injection for use cases
 */
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetLastAccessDateUseCase(
        trackRepository: TrackRepository
    ): GetLastAccessDateUseCase = GetLastAccessDateUseCase(trackRepository)

    @Singleton
    @Provides
    fun provideGetSavedTrackUseCase(
        trackRepository: TrackRepository
    ): GetSavedTrackUseCase = GetSavedTrackUseCase(trackRepository)

    @Singleton
    @Provides
    fun provideGetTrackUseCase(
        trackRepository: TrackRepository
    ): GetTracksUseCase = GetTracksUseCase(trackRepository)

    @Singleton
    @Provides
    fun provideSaveDateUseCase(
        trackRepository: TrackRepository
    ): SaveDateUseCase = SaveDateUseCase(trackRepository)


    @Singleton
    @Provides
    fun provideSaveScreenUseCase(
        trackRepository: TrackRepository
    ): SaveScreenUseCase = SaveScreenUseCase(trackRepository)

    @Singleton
    @Provides
    fun provideGetSavedScreenUseCase(
        trackRepository: TrackRepository
    ): GetSavedScreenUseCase = GetSavedScreenUseCase(trackRepository)

    @Singleton
    @Provides
    fun provideSaveTrackUseCase(
        trackRepository: TrackRepository
    ): SaveTracksUseCase = SaveTracksUseCase(trackRepository)
}