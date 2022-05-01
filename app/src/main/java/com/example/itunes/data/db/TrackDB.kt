package com.example.itunes.data.db
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.itunes.data.model.LastAccessDate
import com.example.itunes.data.model.Screen
import com.example.itunes.data.model.Track
/**
 * Room Database for the persistence layer.
 * Use for storing last access date and screen
 */
@Database(
  entities = [Track::class, LastAccessDate::class, Screen::class],
  version = 1,
  exportSchema = false)
abstract class TrackDB : RoomDatabase() {
  abstract fun getTrackDao(): TrackDao
  abstract fun getDateAccessDao(): DateAccessDao
  abstract fun getScreenDao(): ScreenDao
}