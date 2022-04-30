package com.example.itunes.domain.usecase

import com.example.itunes.domain.repository.TrackRepository

class GetSavedTracksUseCase(
    private val trackRepository: TrackRepository
) {
    fun execute() = trackRepository.getSaveTracks()
}