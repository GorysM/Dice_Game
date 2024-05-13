package com.example.dice_game

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Secure.putInt
import android.widget.Button
import android.widget.TextView

class WinnerActivity : AppCompatActivity() {
    val scorePlayer = 0
    val scoreComp = 0
    var winningScore = "101"
    var winner = ""
    var compCounter = ""
    var playerCounter = ""
    lateinit var humanWinText: TextView
    lateinit var compWinText:TextView
    lateinit var winnerText: TextView
    lateinit var tryAgainBtn: Button
    lateinit var exitBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)
        winnerText = findViewById(R.id.winnerText)
        humanWinText = findViewById(R.id.humanWinText)
        compWinText = findViewById(R.id.compWinText)
        tryAgainBtn = findViewById(R.id.tryAgainBtn)
        exitBtn = findViewById(R.id.exitBtn)
        winningScore = intent.getStringExtra("winningScore").toString()
        winner = intent.getStringExtra("winner").toString()
        compCounter = intent.getStringExtra("compCounter").toString()
        playerCounter = intent.getStringExtra("playerCounter").toString()
        if (winner.equals("Player")){
            winnerText.setText("You win with score: " + winningScore)
            winnerText.setBackgroundResource(R.color.green)

        }
        else {
            winnerText.setText("You lose with score: " + winningScore)
            winnerText.setBackgroundResource(R.color.red)

        }
        humanWinText.setText("H wins: " + playerCounter)
        compWinText.setText("C wins: " + compCounter)
        tryAgainBtn.setOnClickListener{
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            val intent = Intent(this, MainActivity::class.java).apply {

            }
//            val intent = Intent(this, SetScore::class.java)
            intent.putExtra("compCounter", compCounter)
            intent.putExtra("playerCounter", playerCounter)
            startActivity(intent)

        }
        exitBtn.setOnClickListener{
            finishAffinity()

        }


    }
}