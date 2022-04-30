package com.example.itunes.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.itunes.R
import com.example.itunes.data.model.Track
import com.example.itunes.databinding.FragmentInfoBinding

class InfoFragment : BaseFragment<FragmentInfoBinding>(
    FragmentInfoBinding::inflate
) {
    private lateinit var track: Track
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: InfoFragmentArgs by navArgs()
        track = args.selectedTrack
        setupViews()
    }

    private fun setupViews(){
        binding.apply {
            infoToolbar.toolbar.setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
            trackNameTextView.text = track.trackName ?: getString(R.string.null_data)
            dateReleasedTextView.text = track.releaseDate ?:  getString(R.string.null_data)
            ratingTextView.text = track.contentAdvisoryRating ?: getString(R.string.null_data)
            descriptionTextView.text = track.longDescription ?: getString(R.string.null_data)

        }
    }

}