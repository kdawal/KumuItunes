package com.example.itunes.domain.usecase

import com.example.itunes.data.model.LastAccessDate
import com.example.itunes.domain.repository.TrackRepository

class UpdateSaveDateUseCase(
    private val trackRepository: TrackRepository
) {
    suspend fun execute(lastAccessDate: LastAccessDate) = trackRepository.updateDate(lastAccessDate)
}