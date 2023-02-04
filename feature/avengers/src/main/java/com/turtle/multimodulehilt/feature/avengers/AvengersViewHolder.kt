package com.turtle.multimodulehilt.feature.avengers

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.turtle.multimodulehilt.core.model.Hero
import com.turtle.multimodulehilt.feature.avengers.databinding.ListItemHeroBinding

class AvengersViewHolder(
    private val appContext: Context,
    private val binding: ListItemHeroBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Hero) {
        binding.apply {
            binding.listItemHeroName.text = "이름: ${item.name}"
            binding.listItemHeroUrls.text = "관련링크: ${item.urls.count()}개"
            binding.listItemHeroComics.text = "코믹스: ${item.comics.items.count()}개"
            binding.listItemHeroStories.text = "스토리: ${item.stories.items.count()}개"
            binding.listItemHeroEvents.text = "이벤트: ${item.events.items.count()}개"
            binding.listItemHeroSeries.text = "시리즈1: ${item.series.items.count()}개"
            Glide.with(appContext)
                .load("${item.thumbnail.path}.${item.thumbnail.extension}")
                .error(R.drawable.whoishe)
                .placeholder(R.drawable.whoishe)
                .into(binding.listItemHeroImgView)


            executePendingBindings()
        }
    }

}