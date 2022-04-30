package com.example.itunes.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

@Entity(tableName = "track")
data class Track(
    @Json(name = "artistName")
    val artistName: String?,
    @Json(name = "artworkUrl100")
    val artworkUrl100: String?,
    @Json(name = "artworkUrl30")
    val artworkUrl30: String?,
    @Json(name = "artworkUrl60")
    val artworkUrl60: String?,
    @Json(name = "contentAdvisoryRating")
    val contentAdvisoryRating: String?,
    @Json(name = "country")
    val country: String?,
    @Json(name = "primaryGenreName")
    val primaryGenreName: String?,
    @Json(name = "releaseDate")
    val releaseDate: String?,
    @Json(name = "shortDescription")
    val shortDescription: String?,
    @Json(name = "trackCensoredName")
    val trackCensoredName: String?,
    @Json(name = "trackCount")
    val trackCount: Int?,
    @Json(name = "trackExplicitness")
    val trackExplicitness: String?,
    @Json(name = "trackHdPrice")
    val trackHdPrice: Double?,
    @Json(name = "trackHdRentalPrice")
    val trackHdRentalPrice: Double?,
    @PrimaryKey
    @Json(name = "trackId")
    val trackId: Int?,
    @Json(name = "trackName")
    val trackName: String?,
    @Json(name = "trackNumber")
    val trackNumber: Int?,
    @Json(name = "trackPrice")
    val trackPrice: Double?,
    @Json(name = "trackTimeMillis")
    val trackTimeMillis: Int?
)