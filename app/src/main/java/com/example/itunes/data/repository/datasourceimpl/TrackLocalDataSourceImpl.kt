package com.example.itunes.data.repository.datasourceimpl

import com.example.itunes.data.db.DateAccessDao
import com.example.itunes.data.db.TrackDao
import com.example.itunes.data.model.LastAccessDate
import com.example.itunes.data.model.Track
import com.example.itunes.data.repository.datasource.TrackLocalDataSource
import kotlinx.coroutines.flow.Flow

class TrackLocalDataSourceImpl(
    private val dateAccessDao: DateAccessDao,
    private val trackDao: TrackDao
): TrackLocalDataSource {
    override suspend fun saveTrack(track: List<Track>) {
        trackDao.saveTrack(track)
    }

    override fun getSavedTrack(): Flow<List<Track>> {
        return trackDao.getAllTracks()
    }

    override suspend fun saveDate(lastAccessDate: LastAccessDate): Long {
        return dateAccessDao.save(lastAccessDate)
    }

    override suspend fun updateSavedDate(lastAccessDate: LastAccessDate) {
        dateAccessDao.update(lastAccessDate)
    }

    override suspend fun getSavedDate(): List<LastAccessDate> {
        return dateAccessDao.getSaveDate()
    }
}