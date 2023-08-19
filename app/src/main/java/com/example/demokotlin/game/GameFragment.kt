package com.example.demokotlin.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding.buttonGameFragmentReset.setOnClickListener {
            viewModel.reset(
                binding.textViewGameFragmentWatermelonScore.text.toString(),
                binding.textViewGameFragmentDurianScore.text.toString()
            )
            viewModel.show(
                binding.textViewGameFragmentWatermelonScore = viewModel.scoreWatermelon,
                binding.textViewGameFragmentDurian = viewModel.scoreDurian
            )
        }
        binding.buttonGameFragmentScore1Watermelon.setOnClickListener {
            viewModel.incrementScore(
                binding.textViewGameFragmentWatermelonScore.text.toString(),
                binding.textViewGameFragmentDurianScore.text.toString()
            )
            viewModel.show(
                binding.textViewGameFragmentWatermelonScore = viewModel.scoreWatermelon,
                binding.textViewGameFragmentDurian = viewModel.scoreDurian
            )
        }
    }
}