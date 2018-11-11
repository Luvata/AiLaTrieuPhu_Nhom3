package com.group3.`is`.prm391.ailatrieuphu_nhom3.ui.activities

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.group3.`is`.prm391.ailatrieuphu_nhom3.R

class WinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)
        val mp = MediaPlayer.create(this, R.raw.best_player)
        mp.setOnCompletionListener {
            it.stop()
        }
        mp.start()
    }
}
