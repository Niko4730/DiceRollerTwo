package com.example.dicerollertwo

import java.io.Serializable

class HistoryManager : Serializable {

    var doubleCount = 0
    var historyList = mutableListOf<String>()
    var indexCount = 0

    fun addEntry(str : String) {
        historyList.add(0,str)
    }

    fun getList(): MutableList<String> {
        return historyList
    }

    fun resetList(){
        historyList.clear()
    }


}