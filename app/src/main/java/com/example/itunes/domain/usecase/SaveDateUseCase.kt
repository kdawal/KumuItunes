package com.example.itunes.domain.usecase

import com.example.itunes.data.model.LastAccessDate
import com.example.itunes.domain.repository.TrackRepository
/**
 * Use case needed for saving date locally
 */
class SaveDateUseCase(
    private val trackRepository: TrackRepository
) {
    suspend fun execute(lastAccessDate: LastAccessDate) = trackRepository.saveDate(lastAccessDate)
}