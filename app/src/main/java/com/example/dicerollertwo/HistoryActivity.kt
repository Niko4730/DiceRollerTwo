package com.example.dicerollertwo

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.history.*

class HistoryActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history)

        val history = intent.getSerializableExtra("history") as? HistoryManager

        btnReturn.setOnClickListener { finish() }
        btnReset.setOnClickListener() {
            if (history != null){
                resetHistory(history)
            }
        }
        val adapter = HistoryAdapter(this, history!!.getList())

        lvHistory.adapter = adapter
    }


    private fun resetHistory(history: HistoryManager) {
        history.resetList()
        setResult(Activity.RESULT_OK)
        finish()
    }

    internal class HistoryAdapter(context: Context,
                                  private val rolls: MutableList<String>
                                  ): ArrayAdapter<String>(context, 0, rolls)
    {
        private val colors = intArrayOf(
            Color.parseColor("#F8F8F8"),
            Color.parseColor("#E8E8E8")
        )
        override fun getView(position: Int, v: View?, parent: ViewGroup): View {
            var v1: View? = v
            if (v1 == null) {
                val mInflater = LayoutInflater.from(context)
                v1 = mInflater.inflate(R.layout.history_cell, null)
            }

            val resView: View = v1!!
            resView.setBackgroundColor(colors[position % colors.size])
            val f = rolls[position]
            val textView = resView.findViewById<TextView>(R.id.tvHistory)
            textView.text = f

            return resView
        } }
}



