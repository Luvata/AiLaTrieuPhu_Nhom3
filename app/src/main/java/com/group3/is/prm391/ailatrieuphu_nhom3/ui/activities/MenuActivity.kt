package com.group3.`is`.prm391.ailatrieuphu_nhom3.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.group3.`is`.prm391.ailatrieuphu_nhom3.R
import com.group3.`is`.prm391.ailatrieuphu_nhom3.data.AiLaTrieuPhuDatabase
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        AiLaTrieuPhuDatabase.getListResults()
        btnPlay.setOnClickListener{
            startActivity(Intent(this, InsertNameActivity::class.java))
        }

        btnRanking.setOnClickListener{
            startActivity(Intent(this, RankingActivity::class.java))
        }
        // TODO: Make event for rest buttons
    }
}
