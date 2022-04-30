package com.example.itunes.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.itunes.R
import com.example.itunes.data.util.Resource
import com.example.itunes.databinding.FragmentHomeBinding
import com.example.itunes.presentation.adapter.TrackAdapter
import com.example.itunes.presentation.viewmodel.TrackViewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {
    private val trackViewModel by activityViewModels<TrackViewModel>()
    private val trackAdapter by lazy { TrackAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("FragmentHomeLifecycle","OnCreate")
    }
    override fun onResume() {
        super.onResume()
        Log.i("FragmentHomeLifecycle","OnResume")
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setObservers()
        setItemClickListener()
        Log.i("FragmentHomeLifecycle","onViewCreated")
    }
    private fun setItemClickListener(){
        trackAdapter.setOnItemClickListener {
            Log.i("TrackItem","Click")
            val bundle = Bundle().apply {
                putSerializable("selected_track", it)
            }
            findNavController().navigate(
                R.id.action_homeFragment_to_infoFragment,
                bundle
            )
        }
    }

    private fun setRecyclerView() {
        binding.recyclerView.apply {
            adapter = trackAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
    private fun setObservers(){
        trackViewModel.getTrackList().observe(viewLifecycleOwner){
            when(it){
                is Resource.Success -> {
                    Log.i("FragmentHomeLifecycle","observer")
                    it.data?.let { tracks ->
                        trackAdapter.setList(tracks)
                        trackAdapter.notifyDataSetChanged()
                    }

                }
                is Resource.Error -> Log.i("ListResult", it.message.toString())
                is Resource.Loading -> Log.i("ListResult", "Loading...")
            } }

    }
}