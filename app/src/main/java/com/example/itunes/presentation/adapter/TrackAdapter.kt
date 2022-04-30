package com.example.itunes.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.itunes.R
import com.example.itunes.data.model.Track
import com.example.itunes.databinding.RowTrackItemBinding

/**
 * Handles data that will be displayed on the RecyclerView.
 */

class TrackAdapter(): RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {

    private val trackList = ArrayList<Track>()

    /**
     * Use for setting onClickListener for each item
     */
    private var onItemClickListener: ((Track) -> Unit)? = null

    fun setList(tracks: List<Track>) {
        trackList.clear()
        trackList.addAll(tracks)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val listItemBinding = RowTrackItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return TrackViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: TrackViewHolder , position: Int) {
        holder.onBind(trackList[position])
    }

    override fun getItemCount(): Int {
        return trackList.size
    }

    inner class TrackViewHolder(private val binding: RowTrackItemBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(track: Track){
            binding.apply{
                Glide.with(root)
                    .load(track.artworkUrl100)
                    .placeholder(R.drawable.ic_movie)
                    .into(artworkImageView)
                trackNameTextView.text = track.trackName ?: root.context.getString(R.string.null_data)
                genreTextView.text = track.primaryGenreName ?: root.context.getString(R.string.null_data)
                priceTextView.text = root.context.getString(R.string.price, track.trackPrice ?: R.string.null_data)
                layout.setOnClickListener {
                    Log.i("TrackItem", "Adapter Click")
                    onItemClickListener?.let {
                        it(track)
                    }
                }

            }
        }
    }

    /**
     * A public function for setting onClickListener for each item
     *
     * @param listener with Track as reference data
     */
    fun setOnItemClickListener(listener: ((Track) -> Unit)) {
        onItemClickListener = listener
    }

}