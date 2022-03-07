package com.example.dicerollertwo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.dicerollertwo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPlay.setOnClickListener { showRoller() }
    }


    private fun showRoller(){
        val intent = Intent(this, RollerActivity::class.java)
        startActivity(intent)
        Log.d("main","123")
    }


}