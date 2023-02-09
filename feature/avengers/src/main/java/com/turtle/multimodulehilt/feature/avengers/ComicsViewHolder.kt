package com.turtle.multimodulehilt.feature.avengers

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.turtle.multimodulehilt.core.model.Comic
import com.turtle.multimodulehilt.feature.avengers.databinding.ListItemComicsBinding

class ComicsViewHolder(
    private val binding: ListItemComicsBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Comic) {
        Glide.with(binding.listItemComicsImgview)
            .load("${item.thumbnail.path}.${item.thumbnail.extension}")
            .error(R.drawable.whoishe)
            .placeholder(R.drawable.whoishe)
            .into(binding.listItemComicsImgview)
    }

}