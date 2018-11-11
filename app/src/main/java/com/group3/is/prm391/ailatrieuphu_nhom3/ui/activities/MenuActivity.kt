package com.group3.`is`.prm391.ailatrieuphu_nhom3.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.group3.`is`.prm391.ailatrieuphu_nhom3.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btnPlay.setOnClickListener{
//            finish()
            startActivity(Intent(this, InsertNameActivity::class.java))
        }

        // TODO: Make event for rest buttons
    }
}
