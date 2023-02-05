package com.turtle.multimodulehilt.feature.avengers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.turtle.multimodulehilt.core.model.Hero
import com.turtle.multimodulehilt.feature.avengers.databinding.ListItemHeroBinding
import javax.inject.Inject

class AvengersAdapter constructor(
    private val onHeroClick: (Hero) -> Unit
) :
    ListAdapter<Hero, AvengersViewHolder>(AvengersDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvengersViewHolder {
        return AvengersViewHolder(
            ListItemHeroBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AvengersViewHolder, position: Int) {
        holder.bind(onHeroClick, getItem(position))
    }

}

class AvengersDiffCallback : DiffUtil.ItemCallback<Hero>() {

    override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
        return oldItem.id == newItem.id
    }

}