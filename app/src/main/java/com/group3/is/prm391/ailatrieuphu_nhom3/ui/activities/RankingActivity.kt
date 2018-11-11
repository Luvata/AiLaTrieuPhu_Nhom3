package com.group3.`is`.prm391.ailatrieuphu_nhom3.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.group3.`is`.prm391.ailatrieuphu_nhom3.R
import com.group3.`is`.prm391.ailatrieuphu_nhom3.data.AiLaTrieuPhuDatabase
import com.group3.`is`.prm391.ailatrieuphu_nhom3.ui.adapter.RankingListAdapter
import kotlinx.android.synthetic.main.activity_ranking.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class RankingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        listResultView.layoutManager = LinearLayoutManager(this)
        val listResult = AiLaTrieuPhuDatabase.getListResults()
            .sortedBy {
                it.highestLevel
            }.reversed().take(10)

        val adapter = RankingListAdapter(listResult)
        listResultView.adapter = adapter

    }
}
