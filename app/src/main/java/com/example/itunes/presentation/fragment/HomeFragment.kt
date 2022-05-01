package com.example.itunes.presentation.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.itunes.R
import com.example.itunes.data.util.Resource
import com.example.itunes.databinding.FragmentHomeBinding
import com.example.itunes.presentation.MainActivity
import com.example.itunes.presentation.adapter.TrackAdapter
import com.example.itunes.presentation.viewmodel.TrackViewModel

/**
 * A Fragment that will be the landing page
 *
 * Default screen when app is open for the firs time
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {
    private val trackViewModel by activityViewModels<TrackViewModel>()
    private lateinit var trackAdapter: TrackAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        trackAdapter = (activity as MainActivity).trackAdapter
        setRecyclerView()
        setObservers()
        setItemClickListener()
    }

    /**
     * Set the row item set onclick listener
     */
    private fun setItemClickListener(){
        trackAdapter.setOnItemClickListener {
            trackViewModel.selectedTrack.value = it
            trackViewModel.navigateToInfo()
        }
    }

    /**
     * Setup recyclerview for track list
     */
    private fun setRecyclerView() {
        binding.recyclerView.apply {
            adapter = trackAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    /**
     * Observing livedata from our TrackViewModel
     */
    @SuppressLint("NotifyDataSetChanged")
    private fun setObservers(){
        trackViewModel.trackList.observe(viewLifecycleOwner){
            Log.i("TrackList",it.toString())
            if(it == null) return@observe
            when(it){
                is Resource.Success -> {
                    it.data?.let { tracks ->
                        trackAdapter.setList(tracks)
                        trackAdapter.notifyDataSetChanged()
                        hideProgress()
                    }

                }
                is Resource.Error -> {
                    hideProgress()
                    Log.e("Error", it.message.toString())
                }
                is Resource.Loading -> {
                    showProgressBar()
                    Log.i("ListResult", "Loading...")
                }
            }
        }
        /**
         * Observing data changes for the date that was saved in local
         *
         * Display date as list header
         */
        trackViewModel.getLastAccessDate().observe(viewLifecycleOwner){
            if(it.data == null) return@observe
            when(it){
                is Resource.Success ->{
                    val date = it.data.date
                    if(date.isNotEmpty()){
                        trackViewModel.lastAccessDate = date
                        binding.apply {
                            listHeader.visibility = View.VISIBLE
                            dateAccessTextView.text = getString(R.string.date_access, date)
                        }
                    }
                }else -> Log.e("Error", it.message.toString())
            }
        }

    }

    /**
     * Display progress bar when livedata sent
     */
    private fun showProgressBar(){
        binding.progressBar.visibility = View.VISIBLE
    }
    private fun hideProgress(){
        binding.progressBar.visibility = View.GONE
    }
}