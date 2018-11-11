package com.group3.`is`.prm391.ailatrieuphu_nhom3.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.group3.`is`.prm391.ailatrieuphu_nhom3.R
import com.group3.`is`.prm391.ailatrieuphu_nhom3.data.AiLaTrieuPhuDatabase as db
import com.group3.`is`.prm391.ailatrieuphu_nhom3.data.Result
import org.jetbrains.anko.find
import java.text.SimpleDateFormat
import java.util.*

class RankingListAdapter(val top10Ranking: List<Result>) :
    RecyclerView.Adapter<RankingListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_ranking, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = top10Ranking.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindResult(top10Ranking[position])
    }


    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val format = SimpleDateFormat("dd/MM HH:mm")
        private val pnameView = view.find<TextView>(R.id.txtPlayerName)
        private val levelView = view.find<TextView>(R.id.txtHighestLevel)
        private val priceView = view.find<TextView>(R.id.txtPrice)
        private val dateView = view.find<TextView>(R.id.txtDate)


        fun bindResult(result: Result) {
            with(result) {
                pnameView.text = playerName
                levelView.text = highestLevel.toString()
                priceView.text = db.getPrize(endLevel)
                dateView.text = format.format(Date(date))
            }
        }
    }

}