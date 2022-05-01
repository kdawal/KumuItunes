package com.example.itunes.domain.usecase

import com.example.itunes.domain.repository.TrackRepository

/**
 * Use case needed for retrieving saved screen
 */
class GetSavedScreenUseCase(
    private val trackRepository: TrackRepository
) {
    suspend fun execute() = trackRepository.getSavedScreen()
}