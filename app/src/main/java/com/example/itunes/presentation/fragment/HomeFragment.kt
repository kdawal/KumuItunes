package com.example.itunes.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.itunes.R
import com.example.itunes.data.util.Resource
import com.example.itunes.databinding.FragmentHomeBinding
import com.example.itunes.presentation.viewmodel.TrackViewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {
    private val trackViewModel by activityViewModels<TrackViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()

    }
    private fun setObservers(){
        trackViewModel.getTrackList().observe(viewLifecycleOwner){
            when(it){
                is Resource.Success -> Log.i("ListResult", it.data.toString())
                is Resource.Error -> Log.i("ListResult", it.message.toString())
                is Resource.Loading -> Log.i("ListResult", "Loading...")
            }
        }
    }

}