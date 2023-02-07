package com.turtle.multimodulehilt.feature.avengers

import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.turtle.multimodulehilt.core.model.Hero
import com.turtle.multimodulehilt.feature.avengers.databinding.ListItemHeroBinding

class AvengersViewHolder(
    private val binding: ListItemHeroBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(onHeroClick: (View, Hero) -> Unit, item: Hero, imgLoadComplete : () -> Unit) {
        binding.apply {
            hero = item
            listItemHeroImgView.transitionName = item.id.toString()
            Glide.with(listItemHeroImgView)
                .load("${item.thumbnail.path}.${item.thumbnail.extension}")
                .addListener(object: RequestListener<Drawable>{
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        imgLoadComplete()
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        imgLoadComplete()
                        return false
                    }

                })
                .error(R.drawable.whoishe)
                .placeholder(R.drawable.whoishe)
                .into(listItemHeroImgView)
            listItemHeroImgView.setOnClickListener {
                onHeroClick(listItemHeroImgView, item)
            }
        }
    }

}