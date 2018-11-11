package com.group3.`is`.prm391.ailatrieuphu_nhom3.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.group3.`is`.prm391.ailatrieuphu_nhom3.R
import kotlinx.android.synthetic.main.activity_insert_name.*

class InsertNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_name)

        btnStartGame.setOnClickListener{
            val name = edtName.text.toString()

            val gameIntent: Intent = Intent(this, GameActivity::class.java)
            gameIntent.putExtra("playerName", name)
            finish()
            startActivity(gameIntent)
        }
    }
}
