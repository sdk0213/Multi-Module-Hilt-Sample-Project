package com.turtle.multimodulehilt.feature.avengers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.turtle.multimodulehilt.core.model.Comic
import com.turtle.multimodulehilt.feature.avengers.databinding.ListItemComicsBinding

class ComicsAdapter : ListAdapter<Comic, ComicsViewHolder>(ComicsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        return ComicsViewHolder(
            ListItemComicsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class ComicsDiffCallback : DiffUtil.ItemCallback<Comic>() {

    override fun areItemsTheSame(oldItem: Comic, newItem: Comic): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Comic, newItem: Comic): Boolean {
        return oldItem.id == newItem.id
    }

}