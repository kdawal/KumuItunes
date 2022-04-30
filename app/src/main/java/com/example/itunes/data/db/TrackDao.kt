package com.example.itunes.data.db
import androidx.room.*
import com.example.itunes.data.model.Track
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object where you can write your SQLite query
 */
@Dao
interface TrackDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertTrack(tracks: List<Track>)

  @Query("SELECT * FROM track")
  fun getAllTracks(): Flow<List<Track>>

  @Query("DELETE FROM track")
  suspend fun deleteTrack()


  @Transaction
  suspend fun saveTrack(track: List<Track>){
    deleteTrack()
    insertTrack(track)
  }

}