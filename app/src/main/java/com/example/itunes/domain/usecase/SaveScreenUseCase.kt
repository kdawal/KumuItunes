package com.example.itunes.domain.usecase

import com.example.itunes.data.model.Screen
import com.example.itunes.domain.repository.TrackRepository

/**
 * Use case needed for saving screen locally
 */
class SaveScreenUseCase(
    private val trackRepository: TrackRepository
) {
    suspend fun execute(screen: Screen) = trackRepository.saveScreen(screen)
}