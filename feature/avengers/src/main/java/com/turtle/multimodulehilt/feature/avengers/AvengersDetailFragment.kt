package com.turtle.multimodulehilt.feature.avengers

import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
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

    // TODO: 공유 요소를 사용하여 이미지뷰를 출력
    override fun init() {
        Glide.with(binding.imageviewAvengersDetailFragmentCenter)
            .load("${hero.thumbnail.path}.${hero.thumbnail.extension}")
            .error(R.drawable.whoishe)
            .placeholder(R.drawable.whoishe)
            .into(binding.imageviewAvengersDetailFragmentCenter)
    }

}