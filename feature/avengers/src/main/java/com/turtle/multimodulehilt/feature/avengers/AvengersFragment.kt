package com.turtle.multimodulehilt.feature.avengers

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.turtle.multimodulehilt.core.common.base.BaseFragment
import com.turtle.multimodulehilt.core.common.base.EventObserver
import com.turtle.multimodulehilt.core.model.Hero
import com.turtle.multimodulehilt.feature.avengers.databinding.FragmentAvengersBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AvengersFragment : BaseFragment<FragmentAvengersBinding>(R.layout.fragment_avengers) {

    lateinit var avengersAdapter: AvengersAdapter

    private val viewModel: AvengersViewModel by viewModels()

    override fun init() {
        avengersAdapter = AvengersAdapter(
            onHeroClick = {
                navigateToAvengersDetail(it)
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

    fun navigateToAvengersDetail(hero: Hero){
        val direction = AvengersFragmentDirections.actionAvengersFragmentToAvengersDetailFragment(hero)
        findNavController().navigate(direction)
    }
}