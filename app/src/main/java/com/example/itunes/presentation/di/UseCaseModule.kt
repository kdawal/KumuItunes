package com.example.itunes.presentation.di

import com.example.itunes.domain.repository.TrackRepository
import com.example.itunes.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

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
    ): GetSavedTracksUseCase = GetSavedTracksUseCase(trackRepository)

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
    fun provideUpdateSaveDateUseCase(
        trackRepository: TrackRepository
    ): UpdateSaveDateUseCase = UpdateSaveDateUseCase(trackRepository)
}