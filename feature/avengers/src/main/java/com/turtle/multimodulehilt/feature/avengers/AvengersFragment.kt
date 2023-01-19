package com.turtle.multimodulehilt.feature.avengers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.turtle.multimodulehilt.feature.avengers.databinding.FragmentAvengersBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AvengersFragment : Fragment() {

    private var _binding: FragmentAvengersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentAvengersBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}