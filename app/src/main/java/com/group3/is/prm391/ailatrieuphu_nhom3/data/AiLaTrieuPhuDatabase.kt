package com.group3.`is`.prm391.ailatrieuphu_nhom3.data

import com.group3.`is`.prm391.ailatrieuphu_nhom3.ui.App
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import kotlin.random.Random

object AiLaTrieuPhuDatabase {
    private val REWARD: Map<Int, String> = mapOf(
        0 to "0",
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

    val MILESTONE = listOf<Int>(0, 5, 10, 15)

    val QUESTIONS_DATA = "questions.json" // Questions are fixed, and stored in assets
    val RANKING_DATA = "ranking.txt"
    val context = App.instance
    val questionBank = readQuestionFrommFileJson()


    private fun readQuestionFrommFileJson(): List<Question> {
        val json = context.assets.open(QUESTIONS_DATA).bufferedReader().useLines {
            it.reduce { acc, a -> acc + '\n' + a }
        }

        val jsonQuestion = JSONArray(json)
        return 0.until(jsonQuestion.length()).map {
            parseQuestion(jsonQuestion[it] as JSONObject)
        }
    }

    private fun parseQuestion(json: JSONObject): Question {
        val ans = 0
        val content = json.getString("Question")
        val level = json.getInt("Level")
        val choices = listOf<String>(
            json.getString("Answer1"),
            json.getString("Answer2"),
            json.getString("Answer3"),
            json.getString("Answer4")
        )

        return Question(level, content, choices, ans)
    }


    fun getQuestion(level: Int): Question {
        val questionsPool = questionBank.filter { q -> q.level == level }
        val min = 0
        val max = questionsPool.size
        return questionsPool.get(Random.nextInt(min, max))
    }


    fun getPrize(level: Int) = REWARD[level]

    fun getListResults(): List<Result> {
        val file = File(context.filesDir, RANKING_DATA)
        if (file.exists()) {
//            file.delete()
            return file.readLines().map {
                convertStringToRank(it)
            }
        } else {
            return listOf()
        }
    }

    private fun convertStringToRank(s: String): Result {
        val parts = s.split(";;")
        return Result(parts[0], parts[1].toInt(), parts[2].toInt(), parts[3].toLong())
    }

    fun insertResult(result: Result) {
        val file = File(context.filesDir, RANKING_DATA)
        if (!file.exists()) file.createNewFile()
        file.appendText(result.toString() + "\n")
    }


}