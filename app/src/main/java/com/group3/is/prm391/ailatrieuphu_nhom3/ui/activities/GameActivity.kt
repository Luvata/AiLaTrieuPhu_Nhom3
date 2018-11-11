package com.group3.`is`.prm391.ailatrieuphu_nhom3.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.group3.`is`.prm391.ailatrieuphu_nhom3.R
import com.group3.`is`.prm391.ailatrieuphu_nhom3.data.DbOpenHelper
import com.group3.`is`.prm391.ailatrieuphu_nhom3.domain.mapper.DataMapper
import com.group3.`is`.prm391.ailatrieuphu_nhom3.domain.model.Choice
import com.group3.`is`.prm391.ailatrieuphu_nhom3.domain.model.Question
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    var gameFinished = false
    var currentLevel = 1
    lateinit var question: Question

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        txtName.text = intent.getStringExtra("playerName")
        startGame()
    }

    fun startGame() {
        // Add some sound effect if needs
        // TODO: Add event for each buttons helpers
        question = getQuestion(currentLevel)
        bindQuestion()
    }

    fun getQuestion(currentLevel: Int): Question {
        return DataMapper.convertQuestionToQuestionModel(DbOpenHelper.getQuestion(currentLevel))
    }

    fun bindQuestion() {
        txtQuestion.text = question.content

        listOf<Button>(btnA, btnB, btnC, btnD)
            .zip(question.choices)
            .forEach { pair: Pair<Button, Choice> -> bindChoiceToButton(pair) }
    }

    fun bindChoiceToButton(pair: Pair<Button, Choice>) {
        pair.first.setTag(pair.second)
        pair.first.setEnabled(true)
        pair.first.text = pair.second.content // set text for each button
        pair.first.setOnClickListener {
            // set event listener
            if (!pair.second.correct) {
                loseHandler(currentLevel)
            } else if (pair.second.correct && currentLevel < 15) {
                nextQuestionHandler()
            } else {
                winHandler()
            }
        }
    }

    fun nextQuestionHandler() {
        currentLevel += 1
        question = getQuestion(currentLevel)
        bindQuestion()
    }

    fun winHandler() {
        // TODO: Move to new activity, and some effects whatever
        txtQuestion.setText("YOU WIN")

    }

    fun loseHandler(level: Int) {
        // TODO: End game, and move to new activity with reward, save result to database
        gameFinished = true
        txtQuestion.setText("YOU WRONG")
    }

    fun help5050(view: View) {
        // TODO: add some effect sound whatever
        btn5050.setEnabled(false)
        listOf<Button>(btnA, btnB, btnC, btnD).filter {
            !(it.getTag() as Choice).correct
        }.shuffled().take(2).forEach {
            it.text = ""
            it.setEnabled(false)
        }
    }

    fun helpCall(view: View) {
        // TODO: Goi dien thoai cho nguoi than ???
    }

    fun helpAudition(view: View) {
        // TODO: Hoi y kien khan gia: show dialog with vote percent
    }

    fun helpDirectAudition(view: View) {
        // TODO: Help me
    }
}
