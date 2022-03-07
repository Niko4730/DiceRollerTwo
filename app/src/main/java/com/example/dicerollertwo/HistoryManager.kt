package com.example.dicerollertwo

class HistoryManager {

    var historyList = mutableListOf<String>()

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