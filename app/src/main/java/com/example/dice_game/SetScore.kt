package com.example.dice_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.dice_game.R.id.submitScoreBtn

class SetScore : AppCompatActivity() {
    lateinit var submitScoreBtn: Button
    lateinit var setScore: EditText
    var compCounter = "0"
    var playerCounter = "0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_score)
        submitScoreBtn = findViewById(R.id.submitScoreBtn)
        setScore = findViewById(R.id.setScore)
        compCounter= intent.getStringExtra("compCounter").toString()
        playerCounter= intent.getStringExtra("playerCounter").toString()
        if(compCounter==null){
            compCounter="0"
        }
        if(playerCounter==null){
            playerCounter="0"
        }
        submitScoreBtn.setOnClickListener() {
            val intent = Intent(this, Game::class.java)
            intent.putExtra("compCounter", compCounter)
            intent.putExtra("playerCounter", playerCounter)


            intent.putExtra("winningScore", setScore.getText().toString())
            startActivity(intent)
        }
    }
}