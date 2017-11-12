package com.example.mcxia.trivia.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.mcxia.trivia.PersistanceManager
import com.example.mcxia.trivia.R
import com.example.mcxia.trivia.Utilities
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var persistanceManager: PersistanceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        persistanceManager = PersistanceManager(this)

        play_button.setOnClickListener {
            loadGameData()
            //val intent = Intent(this, GameActivity::class.java)
            //startActivity(intent)
        }

        high_scores_button.setOnClickListener {
            val intent = Intent(this@MainActivity, ScoresActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        //fetch high score and display it
        val highScore = persistanceManager.highScore()
        val highScoreValue = highScore?.score ?: 0
        high_score.text = "${getString(R.string.high_score)}: $highScoreValue"
    }

    fun loadGameData() {
        doAsync {
            var gameData = Utilities.loadGameData("presidents.csv", this@MainActivity)
            if(gameData != null && gameData.questions.isNotEmpty()) {

                activityUiThread {
                    val intent = Intent(this@MainActivity, GameActivity::class.java)

                    intent.putExtra("gameData", gameData)
                    startActivity(intent)
                }
            }
            else {
                Log.d(TAG,"problem")
            }
        }
    }

}
