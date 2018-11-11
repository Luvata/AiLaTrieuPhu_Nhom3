package com.group3.`is`.prm391.ailatrieuphu_nhom3.data

data class Question(val level: Int, val content: String, val choices: List<String>, val ans: Int)
data class Result(val playerName: String, val highestLevel: Int, val endLevel: Int, val date: Long) {
    override fun toString(): String {
        return "$playerName;;$highestLevel;;$endLevel;;$date"
    }
}

data class Reward(val level: Int, val prize: Int)