package com.turtle.multimodulehilt.feature.avengers

import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.turtle.multimodulehilt.core.common.base.BaseFragment
import com.turtle.multimodulehilt.core.common.base.EventObserver
import com.turtle.multimodulehilt.core.model.Hero
import com.turtle.multimodulehilt.feature.avengers.databinding.FragmentAvengersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AvengersFragment : BaseFragment<FragmentAvengersBinding>(R.layout.fragment_avengers) {

    lateinit var avengersAdapter: AvengersAdapter

    private val viewModel: AvengersViewModel by viewModels()
    lateinit var listOfHero: List<Hero>

    override fun init() {
        avengersAdapter = AvengersAdapter(
            onHeroClick = { view: View, hero: Hero ->
                navigateToAvengersDetail(view, hero)
            }
        )
        binding.recyclerviewHeroHeroList.adapter = avengersAdapter
        observer()
    }

    private fun observer() {

        viewModel.heroData.observe(this@AvengersFragment) { heroList ->
            avengersAdapter.submitList(heroList)
        }

        viewModel.errorMessage.observe(this@AvengersFragment, EventObserver{
            showToast(it)
        })
    }

    fun navigateToAvengersDetail(view: View, hero: Hero){
        val actions = AvengersFragmentDirections.actionAvengersFragmentToAvengersDetailFragment(hero)
        ViewCompat.setTransitionName(view, hero.id.toString())
        val extras = FragmentNavigatorExtras(view to view.transitionName)
        findNavController().navigate(actions, extras)
    }
}