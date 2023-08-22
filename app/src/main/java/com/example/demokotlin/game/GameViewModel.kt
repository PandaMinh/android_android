package com.example.demokotlin.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private val _scoreWatermelon = MutableLiveData(0)
    val scoreWatermelon: LiveData<Int> get() = _scoreWatermelon

    private val _scoreDurian = MutableLiveData(0)
    val scoreDurian: LiveData<Int> get() = _scoreDurian

    val team1Name = MutableLiveData("Watermelon")
    val team2Name = MutableLiveData("Durian")


    fun incrementScore(isWatermelon: Boolean, score: Int) {
        if (isWatermelon) {
            _scoreWatermelon.value = scoreWatermelon.value?.plus(score)
        } else {
            _scoreDurian.value = scoreDurian.value?.plus(score)
        }
    }

    fun reset() {
        _scoreWatermelon.value = 0
        _scoreDurian.value = 0
    }

}