package com.example.demokotlin.game

import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    var scoreWatermelon : Int = 0
    var scoreDurian : Int = 0

    fun incrementScore( isWatermelon: Boolean){
        if( isWatermelon){
            scoreWatermelon++
        }
        else{
            scoreDurian++
        }
    }

    fun reset(){
        scoreWatermelon = 0
        scoreDurian = 0
    }

    fun show(){
        print(scoreWatermelon)
        print(scoreDurian)
    }
}