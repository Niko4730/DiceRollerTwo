package com.example.dicerollertwo

import android.graphics.drawable.DrawableContainer
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.setMargins
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
        else {
            for (i in 1..6) {
                val dieNumber = 1
                val imageView = ImageView(rollerActivity)
                imageView.layoutParams = LinearLayout.LayoutParams(150, 150)

                var parLay = imageView.layoutParams as ViewGroup.MarginLayoutParams
                parLay.setMargins(10)

                val resId = rollDice(dieNumber)
                imageView.setImageResource(resId)
                diceContainer.addView(imageView)
            }
        }

    }

    private fun loadState(rollerActivity: RollerActivity, diceContainer: LinearLayout) {
        val savedState = hM.getList().first().split("-").map { it.toInt() }

        for (i in 1..savedState.size) {
            val dieNumber = savedState[i +-1]
            val imageView = ImageView(rollerActivity)
            imageView.layoutParams = LinearLayout.LayoutParams(150, 150)

            var parLay = imageView.layoutParams as ViewGroup.MarginLayoutParams
            parLay.setMargins(10)

            var resId = rollDice(dieNumber)
            imageView.setImageResource(resId)
            diceContainer.addView(imageView)
        }
    }

    fun rollCustom(childCount: Int, diceContainer: LinearLayout, rollerActivity: RollerActivity) {
        var hisString = ""
        hM.doubleCount = 0
        for (i in 1..childCount) {

            val b = ran.nextInt(6)
            val random = b + 1

            if (childCount == 2) {
                hM.doubleCount += random
            }

            hisString += random
            if (i != childCount) hisString += "-"

            val imageView = ImageView(rollerActivity)
            imageView.layoutParams = LinearLayout.LayoutParams(150,150)

            var parLay = imageView.layoutParams as ViewGroup.MarginLayoutParams
            parLay.setMargins(10)

            var resId = rollDice(random)
            imageView.setImageResource(resId)
            diceContainer.addView(imageView)
        }
        this.hM.addEntry("Roll: " + hM.indexCount.toString() + " Result: " + hisString)
    }

    private fun rollDice(dieNumber: Int): Int {
        when(dieNumber) {
            1 -> return imgD1
            2 -> return imgD2
            3 -> return imgD3
            4 -> return imgD4
            5 -> return imgD5
            6 -> return imgD6
            else -> return 0
        }

    }


}