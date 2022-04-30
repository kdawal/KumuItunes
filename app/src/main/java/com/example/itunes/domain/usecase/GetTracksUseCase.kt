package com.example.itunes.domain.usecase

import com.example.itunes.domain.repository.TrackRepository

class GetTracksUseCase(
    private val trackRepository: TrackRepository
) {
    suspend fun execute() = trackRepository.getTracks()
}