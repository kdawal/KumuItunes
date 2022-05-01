package com.example.itunes.presentation.di

import com.example.itunes.presentation.adapter.TrackAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dependency injection for Adapter classes
 */
@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Singleton
    @Provides
    fun provideTrackAdapter(): TrackAdapter = TrackAdapter()
}