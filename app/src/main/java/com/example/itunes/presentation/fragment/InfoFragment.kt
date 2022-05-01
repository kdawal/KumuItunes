package com.example.itunes.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.itunes.R
import com.example.itunes.data.model.Track
import com.example.itunes.data.util.Resource
import com.example.itunes.databinding.FragmentInfoBinding
import com.example.itunes.presentation.MainActivity
import com.example.itunes.presentation.adapter.TrackAdapter
import com.example.itunes.presentation.viewmodel.TrackViewModel

/**
 * This Fragment represents the Track information screen whenever the user select
 * a track from the list
 */
class InfoFragment : BaseFragment<FragmentInfoBinding>(
    FragmentInfoBinding::inflate
) {
    private val trackViewModel by activityViewModels<TrackViewModel>()
    private lateinit var trackAdapter: TrackAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        trackAdapter = (activity as MainActivity).trackAdapter
        trackViewModel.selectedTrack.value?.let {
            setupViews(it)
        }
    }

    /**
     * Function that handles UI information
     *
     * @param track: this will be our data model for this view
     */
    private fun setupViews(track: Track){
        binding.apply {
            toolbar.setNavigationOnClickListener {
                Log.i("InfoOnclick",trackAdapter.itemCount.toString())
                if(trackAdapter.itemCount > 0){
                    trackViewModel.navigateBack()
                }else{
                    trackViewModel.navigateToHome()
                }
            }
            trackNameTextView.text = track.trackName ?: getString(R.string.null_data)
            dateReleasedTextView.text = track.releaseDate ?:  getString(R.string.null_data)
            ratingTextView.text = track.contentAdvisoryRating ?: getString(R.string.null_data)
            descriptionTextView.text = track.longDescription ?: getString(R.string.null_data)

        }
    }

}