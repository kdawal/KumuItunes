package com.example.itunes.presentation.viewmodel

import android.util.Log
import androidx.annotation.IdRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.itunes.data.model.LastAccessDate
import com.example.itunes.data.model.Screen
import com.example.itunes.data.model.Track
import com.example.itunes.data.util.Resource
import com.example.itunes.data.util.SingleLiveData
import com.example.itunes.domain.usecase.*
import com.example.itunes.presentation.MainActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.util.*
import javax.inject.Inject

/**
 * A ViewModel that handles all the data needed for our UI
 */
@HiltViewModel
class TrackViewModel @Inject constructor(
    private val getTracksUseCase: GetTracksUseCase,
    private val saveDateUseCase: SaveDateUseCase,
    private val getLastAccessDateUseCase: GetLastAccessDateUseCase,
    private val saveScreenUseCase: SaveScreenUseCase,
    private val getSavedScreenUseCase: GetSavedScreenUseCase,
    private val saveTracksUseCase: SaveTracksUseCase,
    private val getSavedTrackUseCase: GetSavedTrackUseCase
): ViewModel(){

    val trackList = SingleLiveData<Resource<List<Track>>>()
    val selectedTrack = MutableLiveData<Track>()

    /**
     * This livedata is being observed in MainActivity
     *
     * Use for navigation between fragments
     */
    val navigation = MutableLiveData<MainActivity.Navigation>()

    var lastAccessDate = ""

    init {
        getTrackList()
    }

    private fun getTrackList()  {
        trackList.value = Resource.Loading()
        viewModelScope.launch {
            trackList.value = getTracksUseCase.execute()
        }
    }
    fun getLastAccessDate() = liveData {
        emit((getLastAccessDateUseCase.execute()))
    }
    fun saveDate(){
        viewModelScope.launch {
            val currentTime = Calendar.getInstance().time
            val formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime)
            saveDateUseCase.execute(
                LastAccessDate(formattedDate)
            )

        }
    }
    fun getSavedTrack() = liveData {
       emit(getSavedTrackUseCase.execute())
    }
    fun getSavedScreen() = liveData {
        emit(getSavedScreenUseCase.execute())
    }

    /**
     * Saving data functions
     */
    fun saveTrack(){
        viewModelScope.launch {
            selectedTrack.value?.let {
                saveTracksUseCase.execute(it)
            }
        }
    }
    fun saveScreen(){
        viewModelScope.launch {
            navigation.value?.navigationId?.let {
                val screen = Screen(it)
                saveScreenUseCase.execute(screen)
            }
        }
    }

    /**
     * Functions needed for navigation
     */
    fun navigateToHome(){
        navigation.value = MainActivity.Navigation.HOME_FRAGMENT
    }
    fun navigateToInfo(){
        navigation.value = MainActivity.Navigation.INFO_FRAGMENT
    }
    fun navigateBack(){
        navigation.value = MainActivity.Navigation.BACK
    }
}