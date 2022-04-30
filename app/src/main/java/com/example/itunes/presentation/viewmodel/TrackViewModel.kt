package com.example.itunes.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.itunes.data.model.Track
import com.example.itunes.domain.usecase.GetTracksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackViewModel @Inject constructor(
    private val getTracksUseCase: GetTracksUseCase
): ViewModel() {


    fun getTrackList() = liveData {
        emit(getTracksUseCase.execute())
    }
}