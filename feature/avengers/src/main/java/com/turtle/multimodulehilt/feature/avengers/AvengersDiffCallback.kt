package com.turtle.multimodulehilt.feature.avengers

import androidx.recyclerview.widget.DiffUtil
import com.turtle.multimodulehilt.core.model.Hero

class AvengersDiffCallback : DiffUtil.ItemCallback<Hero>() {

    override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
        return oldItem.id == newItem.id
    }

}