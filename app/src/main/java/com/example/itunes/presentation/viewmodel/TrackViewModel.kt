package com.example.itunes.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.itunes.data.model.Track
import com.example.itunes.domain.usecase.GetTracksUseCase
import com.example.itunes.presentation.MainActivity
import com.example.itunes.presentation.adapter.TrackAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@HiltViewModel
class TrackViewModel @Inject constructor(
    private val getTracksUseCase: GetTracksUseCase
): ViewModel(){

    fun getTrackList() = liveData {
        emit(getTracksUseCase.execute())
    }
}