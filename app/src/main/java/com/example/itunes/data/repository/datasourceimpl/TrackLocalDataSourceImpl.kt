package com.example.itunes.data.repository.datasourceimpl

import com.example.itunes.data.db.DateAccessDao
import com.example.itunes.data.db.ScreenDao
import com.example.itunes.data.db.TrackDao
import com.example.itunes.data.model.LastAccessDate
import com.example.itunes.data.model.Screen
import com.example.itunes.data.model.Track
import com.example.itunes.data.repository.datasource.TrackLocalDataSource

/**
 * Implements local datasource for interacting with DAO
 */
class TrackLocalDataSourceImpl(
    private val dateAccessDao: DateAccessDao,
    private val trackDao: TrackDao,
    private val screenDao: ScreenDao
): TrackLocalDataSource {
    override suspend fun saveTrack(track: Track) {
        trackDao.saveTrack(track)
    }

    override suspend fun getSavedTrack(): List<Track> {
        return trackDao.getAllTracks()
    }

    override suspend fun saveDate(lastAccessDate: LastAccessDate) {
        dateAccessDao.saveDate(lastAccessDate)
    }


    override suspend fun getSavedDate(): List<LastAccessDate> {
        return dateAccessDao.getSaveDate()
    }

    override suspend fun saveScreen(screen: Screen) {
        screenDao.saveScreen(screen)
    }

    override suspend fun getSavedScreen(): List<Screen> {
        return screenDao.getScreen()
    }

}