package com.turtle.multimodulehilt.feature.avengers

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.turtle.multimodulehilt.core.model.Hero
import com.turtle.multimodulehilt.feature.avengers.databinding.ListItemHeroBinding

class AvengersViewHolder(
    private val binding: ListItemHeroBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(onHeroClick: (View, Hero) -> Unit, item: Hero) {
        binding.apply {
            hero = item
            Glide.with(listItemHeroImgView)
                .load("${item.thumbnail.path}.${item.thumbnail.extension}")
                .error(R.drawable.whoishe)
                .placeholder(R.drawable.whoishe)
                .into(listItemHeroImgView)
            listItemHeroImgView.setOnClickListener {
                onHeroClick(listItemHeroImgView, item)
            }
        }
    }

}