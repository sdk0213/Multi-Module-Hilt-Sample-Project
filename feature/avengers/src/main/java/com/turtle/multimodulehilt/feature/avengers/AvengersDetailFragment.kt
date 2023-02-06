package com.turtle.multimodulehilt.feature.avengers

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.SharedElementCallback
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.turtle.multimodulehilt.core.common.base.BaseFragment
import com.turtle.multimodulehilt.core.model.Hero
import com.turtle.multimodulehilt.feature.avengers.databinding.FragmentAvengersDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AvengersDetailFragment :
    BaseFragment<FragmentAvengersDetailBinding>(R.layout.fragment_avengers_detail) {

    private val args: AvengersDetailFragmentArgs by navArgs()
    private val hero: Hero by lazy {
        args.hero
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(R.transition.shared_image)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    // TODO: 공유 요소를 사용하여 이미지뷰를 출력
    override fun init() {
        binding.imageviewAvengersDetailFragmentCenter.transitionName = args.hero.id.toString()
        Glide.with(binding.imageviewAvengersDetailFragmentCenter)
            .load("${hero.thumbnail.path}.${hero.thumbnail.extension}")
            .into(binding.imageviewAvengersDetailFragmentCenter)
    }

}