package com.example.demokotlin.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.demokotlin.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.buttonGameFragmentReset.setOnClickListener {
            viewModel.reset()
        }

        binding.buttonGameFragmentScore1Watermelon.setOnClickListener {
            viewModel.incrementScore(true, 1)
        }

        binding.buttonGameFragmentScore2Watermelon.setOnClickListener {
            viewModel.incrementScore(true, 2)

        }

        binding.buttonGameFragmentScore1Durian.setOnClickListener {
            viewModel.incrementScore(false, 1)
        }
    }
}