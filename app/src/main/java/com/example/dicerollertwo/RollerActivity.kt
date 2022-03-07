package com.example.dicerollertwo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SeekBar
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.dicerollertwo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.roller.*

class RollerActivity: AppCompatActivity() {

    var historyManager = HistoryManager()
    var diceCount = 6;
    var diceRoller = DiceRoller(historyManager)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.roller)

        try {
            if (savedInstanceState != null){
                var state = savedInstanceState.getSerializable("historyObject") as HistoryManager
                historyManager = state
                diceRoller = DiceRoller(state)
                diceRoller.default(this, diceContainer)
            }
            if (savedInstanceState == null){
                historyManager = HistoryManager()
                diceRoller = DiceRoller(historyManager)
                diceRoller.default(this, diceContainer)
            }
        }
        catch (e : Exception) {
            Log.d("TAG", "Something wrong")
        }

        btnHistory.setOnClickListener { showHistory() }
        btnRoll.setOnClickListener { onClickRoll() }
        numberOfDice.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                diceCount = i+1
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }

    private fun onClickRoll() {
        historyManager.indexCount += 1
        val numDice = diceCount
        diceContainer.removeAllViews()
        diceRoller.rollCustom(numDice, diceContainer, this)
        addDist()
    }

    private fun addDist() {
        val imageView = ImageView(this)
        imageView.layoutParams = LinearLayout.LayoutParams(20, 20)
        var resId = R.drawable.hex
        imageView.setImageResource(resId)
        when (historyManager.doubleCount) {
            2 -> dis2.addView(imageView)
            3 -> dis3.addView(imageView)
            4 -> dis4.addView(imageView)
            5 -> dis5.addView(imageView)
            6 -> dis6.addView(imageView)
            7 -> dis7.addView(imageView)
            8 -> dis8.addView(imageView)
            9 -> dis9.addView(imageView)
            10 -> dis10.addView(imageView)
            11 -> dis11.addView(imageView)
            12 -> dis12.addView(imageView)
        }
    }

    private fun showHistory() {
        val intent = Intent(this, HistoryActivity::class.java)
        intent.putExtra("history", historyManager)
        getResult.launch(intent)
    }

    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                historyManager.resetList()
            }
        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("historyObject", historyManager)
    }

}