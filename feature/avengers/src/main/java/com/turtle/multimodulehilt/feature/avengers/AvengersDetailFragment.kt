package com.turtle.multimodulehilt.feature.avengers

import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.turtle.multimodulehilt.core.common.base.BaseFragment
import com.turtle.multimodulehilt.core.common.base.EventObserver
import com.turtle.multimodulehilt.core.model.Hero
import com.turtle.multimodulehilt.feature.avengers.databinding.FragmentAvengersDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AvengersDetailFragment :
    BaseFragment<FragmentAvengersDetailBinding>(R.layout.fragment_avengers_detail) {

    lateinit var comicsAdapter: ComicsAdapter
    private val viewModel: AvengersDetailViewModel by viewModels()

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
        comicsAdapter = ComicsAdapter()
        binding.recyclerviewComicHeroList.adapter = comicsAdapter
        observer()
    }

    private fun observer() {

        viewModel.heroData.observe(this@AvengersDetailFragment) { hero ->
            binding.hero = hero
            binding.imageviewAvengersDetailFragmentHero.transitionName = hero.id.toString()
            Glide.with(binding.imageviewAvengersDetailFragmentHero)
                .load("${hero.thumbnail.path}.${hero.thumbnail.extension}")
                .into(binding.imageviewAvengersDetailFragmentHero)
        }

        viewModel.comicData.observe(this@AvengersDetailFragment) { comic ->
            // 최대 6개의 정보만 표시 (Nested Scroll View 와 혼합 사용시 RecyclerView ViewHolder 재활용의 이점이 사라져
            // 이를 Recycler 의 ViewType 형태로 전부 처리를 해야하지만 샘플앱의 걸맞게 그저 데이터를 제한하도록 진행항
            comicsAdapter.submitList(if(comic.size > 6) comic.subList(0, 6) else comic)
        }

        viewModel.errorMessage.observe(this@AvengersDetailFragment, EventObserver {
            showToast(it)
        })
    }

}