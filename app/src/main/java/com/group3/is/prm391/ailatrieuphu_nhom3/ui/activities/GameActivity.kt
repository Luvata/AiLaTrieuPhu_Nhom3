package com.group3.`is`.prm391.ailatrieuphu_nhom3.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.group3.`is`.prm391.ailatrieuphu_nhom3.R
import com.group3.`is`.prm391.ailatrieuphu_nhom3.data.Result
import com.group3.`is`.prm391.ailatrieuphu_nhom3.data.AiLaTrieuPhuDatabase as db
import com.group3.`is`.prm391.ailatrieuphu_nhom3.domain.mapper.DataMapper
import com.group3.`is`.prm391.ailatrieuphu_nhom3.domain.model.Choice
import com.group3.`is`.prm391.ailatrieuphu_nhom3.domain.model.Question
import kotlinx.android.synthetic.main.activity_game.*
import org.jetbrains.anko.startActivity

class GameActivity : AppCompatActivity() {

    var gameFinished = false
    var currentLevel = 1
    lateinit var question: Question
    lateinit var playerName: String
//    val buttonSound = MediaPlayer.create(this, R.raw.touch_sound)
//    var buttons = listOf<Button>(btnA, btnB, btnC, btnD)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        playerName = intent.getStringExtra("playerName")
        txtName.text = playerName
        startGame()
    }

    fun startGame() {
        // Add some sound effect if needs
        // TODO: Add event for each buttons helpers
        question = getQuestion(currentLevel)
        bindQuestion()
    }

    fun getQuestion(currentLevel: Int): Question {
        return DataMapper.convertQuestionToQuestionModel(db.getQuestion(currentLevel))
    }


    fun bindQuestion() {
        txtQuestion.text = question.content
        txtReward.text = "Level " + currentLevel + " prize: " + db.getPrize(currentLevel)
        listOf<Button>(btnA, btnB, btnC, btnD)
            .zip(question.choices)
            .forEach { pair: Pair<Button, Choice> -> bindChoiceToButton(pair) }
    }

    fun bindChoiceToButton(pair: Pair<Button, Choice>) {
        pair.first.setTag(pair.second)
        pair.first.setEnabled(true)
        pair.first.text = pair.first.hint.toString() + ". " + pair.second.content // set text for each button
        pair.first.setOnClickListener {
            if (!pair.second.correct) {
                loseHandler()
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
        txtQuestion.setText("YOU WIN")
        val prizeLevel = db.MILESTONE.filter { it <= currentLevel }.max()!!

        db.insertResult(Result(playerName, currentLevel, prizeLevel, System.currentTimeMillis()))

        finish()

        startActivity(Intent(this, WinActivity::class.java))
    }

    fun loseHandler() {
        // TODO: End game, and move to new activity with reward, save result to database
        gameFinished = true
        val prizeLevel = db.MILESTONE.filter { it <= currentLevel }.max()!!
        db.insertResult(Result(playerName, currentLevel, prizeLevel, System.currentTimeMillis()))
        finish()
        val intent = Intent(this, LoseActivity::class.java)
        intent.putExtra("prize", db.getPrize(prizeLevel))
        startActivity(intent)
        Log.d("test", db.getListResults().size.toString())

//        txtQuestion.setText("YOU WRONG")
    }

    fun help5050(view: View) {
        // TODO: add some effect sound whatever
        btn5050.setEnabled(false)
        listOf<Button>(btnA, btnB, btnC, btnD).filter {
            !(it.getTag() as Choice).correct // select wrong buttons
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

    override fun onBackPressed() {
        super.onBackPressed()
        // TODO: Show dialog : ban co muon thoat
    }
}
