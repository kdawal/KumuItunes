package com.example.itunes.domain.usecase

import com.example.itunes.data.model.Track
import com.example.itunes.domain.repository.TrackRepository

/**
 * Use case needed for saving track locally
 */
class SaveTracksUseCase(
    private val trackRepository: TrackRepository
) {
    suspend fun execute(track: Track) = trackRepository.saveTrack(track)
}