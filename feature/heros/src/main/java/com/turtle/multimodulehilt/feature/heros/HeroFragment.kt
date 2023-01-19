package com.turtle.multimodulehilt.feature.heros

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.turtle.multimodulehilt.feature.heros.databinding.FragmentHeroBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroFragment : Fragment() {

    private var _binding: FragmentHeroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentHeroBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}