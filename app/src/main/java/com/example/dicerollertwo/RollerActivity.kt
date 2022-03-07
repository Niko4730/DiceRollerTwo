package com.example.dicerollertwo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dicerollertwo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.roller.*

class RollerActivity: AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.roller)
        btnHistory.setOnClickListener { showHistory() }
        btnRoll.setOnClickListener { onClickRoll() }
        Log.d("create","asdadsdsdsadsadddddd")

    }

    private fun showHistory() {

        Log.d("tag","thisshit")
    }

    fun onClickRoll() {

    }


}