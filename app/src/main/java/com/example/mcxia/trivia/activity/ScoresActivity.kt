package com.example.mcxia.trivia.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.mcxia.trivia.PersistanceManager
import com.example.mcxia.trivia.R
import com.example.mcxia.trivia.ScoresAdapter
import kotlinx.android.synthetic.main.activity_scores.*

class ScoresActivity : AppCompatActivity() {

    lateinit private var persistanceManager: PersistanceManager
    lateinit private var scoresAdapter: ScoresAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)

        persistanceManager = PersistanceManager(this)
        val scores = persistanceManager.fetchScores()

        scoresAdapter = ScoresAdapter(scores)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = scoresAdapter
    }
}
