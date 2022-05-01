package com.example.itunes.data.db
import androidx.room.*
import com.example.itunes.data.model.Track

/**
 * Data Access Object where you can write your SQLite query for Track table
 */
@Dao
interface TrackDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertTrack(tracks: Track)

  @Query("SELECT * FROM track")
  suspend fun getAllTracks(): List<Track>

  @Query("DELETE FROM track")
  suspend fun deleteTrack()


  @Transaction
  suspend fun saveTrack(track: Track){
    deleteTrack()
    insertTrack(track)
  }

}