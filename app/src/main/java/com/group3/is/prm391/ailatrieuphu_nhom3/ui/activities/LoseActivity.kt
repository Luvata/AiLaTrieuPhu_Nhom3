package com.group3.`is`.prm391.ailatrieuphu_nhom3.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.group3.`is`.prm391.ailatrieuphu_nhom3.R
import kotlinx.android.synthetic.main.activity_lose.*

class LoseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lose)

        txtPrizeFinal.text = intent.getStringExtra("prize")
    }
}
