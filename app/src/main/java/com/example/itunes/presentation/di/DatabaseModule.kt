package com.example.itunes.presentation.di
import android.app.Application
import androidx.room.Room
import com.example.itunes.data.db.DateAccessDao
import com.example.itunes.data.db.TrackDB
import com.example.itunes.data.db.TrackDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideTrackDatabase(app: Application): TrackDB = Room.databaseBuilder(app, TrackDB::class.java, "Track_DB")
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideTrackDao(trackDB: TrackDB): TrackDao = trackDB.getTrackDao()

    @Singleton
    @Provides
    fun provideDateAccessDao(trackDB: TrackDB): DateAccessDao = trackDB.getDateAccessDao()
}