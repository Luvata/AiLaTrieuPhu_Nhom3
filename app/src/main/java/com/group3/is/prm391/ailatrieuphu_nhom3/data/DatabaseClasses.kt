package com.group3.`is`.prm391.ailatrieuphu_nhom3.data

data class Question(val level: Int, val content: String, val choices: List<String>, val ans: Int)
data class Ranking(val playerName: String, val highestLevel: Int, val endLevel: Int, val date: String) // end level: level prize which player get
data class Reward(val level: Int, val prize: Int)