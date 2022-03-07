package com.example.dicerollertwo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.history.*

class HistoryActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history)
        btnReturn.setOnClickListener { showRoller() }
    }


    private fun showRoller(){
        setContentView(R.layout.roller)
    }


    fun test(){

        var names = listOf("test1","test2","test3")
        for (name in names) {

        }

    }


}