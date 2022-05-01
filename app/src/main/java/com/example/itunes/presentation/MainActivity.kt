package com.example.itunes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.IdRes
import androidx.navigation.findNavController
import com.example.itunes.R
import com.example.itunes.data.util.Resource
import com.example.itunes.databinding.ActivityMainBinding
import com.example.itunes.presentation.adapter.TrackAdapter
import com.example.itunes.presentation.viewmodel.TrackViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Activity that holds all of our Fragments
 *
 * Uses adapter, injected and singleton to share same instance throughout the app
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var trackAdapter: TrackAdapter

    private lateinit var binding: ActivityMainBinding
    private val trackViewModel by viewModels<TrackViewModel>()
    private val navController by lazy { findNavController(R.id.navFragmentContainer) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObservers()
    }

    /**
     * Observing livedata from TrackViewModel
     *
     * Any changes in livedata, this functions will react accordingly
     */
    private fun setObservers(){
        trackViewModel.getSavedScreen().observe(this){
            if(it == null) return@observe
            when(it){
                is Resource.Success ->{
                    it.data?.id?.let { id ->
                        Log.i("SavedScreen", id.toString())
                        if(id == R.id.infoFragment){
                            trackViewModel.navigateToInfo()
                        }
                    }
                }else -> Log.e("Error", it.message.toString())
            }

        }
        trackViewModel.getSavedTrack().observe(this){
            if(it == null) return@observe
            when(it){
                is Resource.Success ->{
                    it.data?.let { track ->
                        trackViewModel.selectedTrack.value = track
                    }
                }else -> Log.e("Error", it.message.toString())
            }
        }

        trackViewModel.navigation.observe(this){
            if(it == null) return@observe
            when(it){
                Navigation.BACK -> onBackPressed()
                else -> navController.navigate(it.navigationId)
            }
        }

    }

    /**
     * Saves the date and screen whenever the app attempt to stop
     */
    override fun onStop() {
        super.onStop()
        trackViewModel.saveDate()
        trackViewModel.saveScreen()
        trackViewModel.saveTrack()
    }

    /**
     * Class that holds the data for navigation
     */
    enum class Navigation(@IdRes val navigationId: Int){
        HOME_FRAGMENT(R.id.homeFragment),
        INFO_FRAGMENT(R.id.infoFragment),
        BACK(-1)
    }

}