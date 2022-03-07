package com.example.dicerollertwo

import android.graphics.drawable.DrawableContainer
import android.widget.LinearLayout
import java.util.*

class DiceRoller {

    val imgD1 = R.drawable.dice1
    val imgD2 = R.drawable.dice2
    val imgD3 = R.drawable.dice3
    val imgD4 = R.drawable.dice4
    val imgD5 = R.drawable.dice5
    val imgD6 = R.drawable.dice6

    val hM : HistoryManager
    val ran : Random

    constructor(historyManager: HistoryManager){
        this.hM = historyManager
        this.ran = Random()
    }


    fun default(rollerActivity: RollerActivity, diceContainer: LinearLayout) {

        if (!hM.getList().isEmpty()){
            loadState(rollerActivity, diceContainer)
        }

    }

    private fun loadState(rollerActivity: RollerActivity, diceContainer: LinearLayout) {

    }


}