package com.turtle.multimodulehilt.feature.avengers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.turtle.multimodulehilt.core.model.Hero
import com.turtle.multimodulehilt.feature.avengers.databinding.ListItemHeroBinding
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

class AvengersAdapter @Inject constructor(
    @ActivityContext private val context: Context
): ListAdapter<Hero, AvengersViewHolder>(AvengersDiffCallback())  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvengersViewHolder {
        return AvengersViewHolder(
            context,
            ListItemHeroBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AvengersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}