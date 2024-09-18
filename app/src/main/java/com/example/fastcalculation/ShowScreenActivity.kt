package com.example.fastcalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fastcalculation.Extras.EXTRA_SETTINGS
import com.example.fastcalculation.Result.RESULT
import com.example.fastcalculation.databinding.ActivityShowScreenBinding

class ShowScreenActivity : AppCompatActivity() {

    private val activityShowScreenBinding: ActivityShowScreenBinding by lazy {
        ActivityShowScreenBinding.inflate(layoutInflater)
    }

    private lateinit var settings: Settings
    private lateinit var gameResult: GameResult

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(activityShowScreenBinding.root)

        setSupportActionBar(activityShowScreenBinding.gameTbIn.gameTb)
        supportActionBar?.apply {
            title = getString(R.string.app_name)
            subtitle = "Game Result"
        }
        settings = intent.getParcelableExtra(EXTRA_SETTINGS) ?: Settings()
        gameResult = intent.getParcelableExtra(RESULT) ?: GameResult()

        with(activityShowScreenBinding) {
            roundShowTv.text = getString(R.string.points)
            val points = gameResult.hits * 10f / (gameResult.totalGameTime / 1000L)
            "%.1f".format(points).also {
                questionShowTv.text = it
            }
        }

        clickButton()
    }

    fun clickButton() {
        activityShowScreenBinding.apply {
            rebootBt.setOnClickListener {
                roundShowTv.visibility = View.GONE
                questionShowTv.visibility = View.GONE
                rebootBt.visibility  = View.GONE

                supportActionBar?.apply {
                    title = getString(R.string.app_name)
                    subtitle = "Game"
                }
                supportFragmentManager.beginTransaction().replace(R.id.gameFl, GameFragment.newInstance(settings)).commit()
            }

        }
    }

}