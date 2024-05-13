package com.example.dice_game

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var dialog: Dialog
    lateinit var gameButton: Button
    var compCounter = "0"
    var playerCounter ="0"

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gameButton = findViewById(R.id.newGameButton)
            compCounter= intent.getStringExtra("compCounter").toString()
            playerCounter= intent.getStringExtra("playerCounter").toString()
            if(compCounter==null){
                compCounter="0"
            }
            if(playerCounter==null){
                playerCounter="0"
            }
//        gameButton.setOnClickListener() {
//            val intent = Intent(this, Game::class.java)
//            startActivity(intent)
//        }
//
        gameButton.setOnClickListener() {
            val intent = Intent(this, SetScore::class.java)
            intent.putExtra("compCounter", compCounter)
            intent.putExtra("playerCounter", playerCounter)
            startActivity(intent)
        }
            var about=findViewById<Button>(R.id.aboutButton)
            about.setOnClickListener{
                dialog=Dialog(this)
                dialog.setContentView(R.layout.about)
                dialog.setCancelable(true)
                dialog.show()
            }
    }



}