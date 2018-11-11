package com.group3.`is`.prm391.ailatrieuphu_nhom3.data

import kotlin.random.Random

object DbOpenHelper {
    private val REWARD: Map<Int, String> = mapOf(
        1 to "200",
        2 to "400",
        3 to "600",
        4 to "1000",
        5 to "2000",
        6 to "3000",
        7 to "6,000",
        8 to "10,000",
        9 to "14,000",
        10 to "22,000",
        11 to "30,000",
        12 to "40,000",
        13 to "60,000",
        14 to "85,000",
        15 to "150,000"
    )

    private val DATABASE_NAME = "some names"
    private val questionBank: List<Question> = listOf(
        Question(1, "111", listOf("W1", "W2", "W3", "W4"), 1),
        Question(2, "22", listOf("W1", "W2", "W3", "W4"), 2),
        Question(3, "33", listOf("W1", "W2", "W3", "W4"), 3),
        Question(4, "44", listOf("W1", "W2", "W3", "W4"), 0),
        Question(5, "5", listOf("W1", "W2", "W3", "W4"), 1),
        Question(6, "6", listOf("W1", "W2", "W3", "W4"), 2),
        Question(7, "7", listOf("W1", "W2", "W3", "W4"), 1),
        Question(8, "8", listOf("W1", "W2", "W3", "W4"), 3),
        Question(9, "9", listOf("W1", "W2", "W3", "W4"), 1),
        Question(10, "10", listOf("W1", "W2", "W3", "W4"), 2),
        Question(11, "11", listOf("W1", "W2", "W3", "W4"), 2),
        Question(12, "12", listOf("W1", "W2", "W3", "W4"), 1),
        Question(13, "13", listOf("W1", "W2", "W3", "W4"), 3),
        Question(14, "14", listOf("W1", "W2", "W3", "W4"), 1),
        Question(15, "15", listOf("W1", "W2", "W3", "W4"), 1)
    )

    fun getQuestion(level: Int): Question {
        val questionsPool = questionBank.filter { q -> q.level == level }
        val min = 0
        val max = questionsPool.size
        return questionsPool.get(Random.nextInt(min, max))
    }
}