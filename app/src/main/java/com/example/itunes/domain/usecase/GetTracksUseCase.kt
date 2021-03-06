package com.example.itunes.domain.usecase

import com.example.itunes.domain.repository.TrackRepository
/**
 * Use case needed for retrieving track list from api
 */
class GetTracksUseCase(
    private val trackRepository: TrackRepository
) {
    suspend fun execute() = trackRepository.getTracks()
}