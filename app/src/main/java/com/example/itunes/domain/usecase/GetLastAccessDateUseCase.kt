package com.example.itunes.domain.usecase

import com.example.itunes.domain.repository.TrackRepository

/**
 * Use case needed for retrieving saved date
 */
class GetLastAccessDateUseCase(
    private val trackRepository: TrackRepository
) {
    suspend fun execute() = trackRepository.getSaveDate()
}