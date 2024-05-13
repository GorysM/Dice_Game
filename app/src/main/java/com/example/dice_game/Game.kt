package com.example.dice_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.io.IOException
import java.util.Random

class Game : AppCompatActivity() {
    lateinit var scoreBtn:Button
    lateinit var playerScoreText: TextView
    lateinit var compScoreText: TextView
    lateinit var rethrowBtn : Button
    lateinit var dice1 : ImageView
    lateinit var dice2 : ImageView
    lateinit var dice3 : ImageView
    lateinit var dice4 : ImageView
    lateinit var dice5 : ImageView
    lateinit var computerDice1 : ImageView
    lateinit var computerDice2 : ImageView
    lateinit var computerDice3 : ImageView
    lateinit var computerDice4 : ImageView
    lateinit var computerDice5 : ImageView
    lateinit var imageList:ArrayList<Int>
    lateinit var throwbtn: Button
    var rethrowCount=0
    var playerResultList = mutableListOf<Int>()
    var compResultlist = mutableListOf<Int>()
    var randomNum:Int=0
    var pdicepick1 = true
    var pdicepick2 = true
    var pdicepick3 = true
    var pdicepick4 = true
    var pdicepick5 = true
    var winningScore = 101
    var playerCounter = 0
    var compCounter = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        winningScore = Integer.parseInt(intent.getStringExtra("winningScore").toString())
        try {
            compCounter= Integer.parseInt(intent.getStringExtra("compCounter").toString())
            playerCounter= Integer.parseInt(intent.getStringExtra("playerCounter").toString())
        }
        catch (e:NumberFormatException){
            compCounter = 0
            playerCounter=0
        }
        dice1 = findViewById(R.id.imageView15)
        dice1.setOnClickListener { pdicepick1 = false }
        dice2 = findViewById(R.id.imageView16)
        dice2.setOnClickListener { pdicepick2 = false }
        dice3 = findViewById(R.id.imageView14)
        dice3.setOnClickListener { pdicepick3 = false }
        dice4 = findViewById(R.id.imageView17)
        dice4.setOnClickListener { pdicepick4 = false }
        dice5 = findViewById(R.id.imageView18)
        dice5.setOnClickListener { pdicepick5 = false }
        computerDice1 = findViewById(R.id.imageView11)
        computerDice2 = findViewById(R.id.imageView3)
        computerDice3 = findViewById(R.id.imageView7)
        computerDice4 = findViewById(R.id.imageView12)
        computerDice5 = findViewById(R.id.imageView13)
        scoreBtn=findViewById(R.id.scoreBtn)
        rethrowBtn=findViewById(R.id.rethrowBtn)

        rethrowBtn.visibility= View.INVISIBLE
        scoreBtn.visibility=View.INVISIBLE
        imageList = arrayListOf(R.drawable.die_face_1, R.drawable.die_face_2, R.drawable.die_face_3,R.drawable.die_face_4,R.drawable.die_face_5,R.drawable.die_face_6)
        throwbtn = findViewById(R.id.throwBtn)
        throwbtn.setOnClickListener{
            throwbtn.setEnabled(false)
            rethrowBtn.visibility= View.VISIBLE
            scoreBtn.visibility=View.VISIBLE
            randomNum=Random().nextInt(6)
            playerResultList.add(randomNum+1)
            dice1.setImageResource(imageList[randomNum])

            randomNum=Random().nextInt(6)
            playerResultList.add(randomNum+1)
            dice2.setImageResource(imageList[randomNum])

            randomNum=Random().nextInt(6)
            playerResultList.add(randomNum+1)
            dice3.setImageResource(imageList[randomNum])

            randomNum=Random().nextInt(6)
            playerResultList.add(randomNum+1)
            dice4.setImageResource(imageList[randomNum])

            randomNum=Random().nextInt(6)
            playerResultList.add(randomNum+1)
            dice5.setImageResource(imageList[randomNum])

            randomNum=Random().nextInt(6)
            computerDice1.setImageResource(imageList[randomNum])
            compResultlist.add(randomNum+1)

            randomNum=Random().nextInt(6)
            compResultlist.add(randomNum+1)
            computerDice2.setImageResource(imageList[randomNum])

            randomNum=Random().nextInt(6)
            compResultlist.add(randomNum+1)
            computerDice3.setImageResource(imageList[randomNum])

            randomNum=Random().nextInt(6)
            compResultlist.add(randomNum+1)
            computerDice4.setImageResource(imageList[randomNum])

            randomNum=Random().nextInt(6)
            compResultlist.add(randomNum+1)
            computerDice5.setImageResource(imageList[randomNum])




        }
        rethrowBtn.setOnClickListener{
            if(rethrowCount<1){
            if(pdicepick1){
                randomNum=Random().nextInt(6)
                playerResultList[playerResultList.size-5]=randomNum+1
                dice1.setImageResource(imageList[randomNum])
                pdicepick1 = true


            }
            if (pdicepick2){
                randomNum=Random().nextInt(6)
                playerResultList[playerResultList.size-4]=randomNum+1
                dice2.setImageResource(imageList[randomNum])
                pdicepick2 = true

            }
            if (pdicepick3){
                randomNum=Random().nextInt(6)
                playerResultList[playerResultList.size-3]=randomNum+1
                dice3.setImageResource(imageList[randomNum])
                pdicepick3 = true


            }
            if (pdicepick4){
                randomNum=Random().nextInt(6)
                playerResultList[playerResultList.size-2]=randomNum+1
                dice4.setImageResource(imageList[randomNum])
                pdicepick4 = true
            }
            if (pdicepick5){
                randomNum=Random().nextInt(6)
                playerResultList[playerResultList.size-1]=randomNum+1
                dice5.setImageResource(imageList[randomNum])
                pdicepick5 = true

            }
                rethrowCount++
            }else{
                rethrowCount=0
                updateScore()
                rethrowBtn.visibility= View.INVISIBLE
            }

            var counter = 0
            var index = 0
            for (result in compResultlist){
                if (result<4 && counter<5){
                    counter++
                   if(index == 0){
                       randomNum=Random().nextInt(6)
                       computerDice1.setImageResource(imageList[randomNum])
//                       compResultlist.add(randomNum+1)
                       compResultlist[index]=randomNum+1

                   }
                    else if (index==1){
                       randomNum=Random().nextInt(6)
                       computerDice2.setImageResource(imageList[randomNum])
//                       compResultlist.add(randomNum+1)
                       compResultlist[index]=randomNum+1

                   }
                   else if (index==2){
                       randomNum=Random().nextInt(6)
                       computerDice3.setImageResource(imageList[randomNum])
//                       compResultlist.add(randomNum+1)
                       compResultlist[index]=randomNum+1

                   }
                   else if (index==3){
                       randomNum=Random().nextInt(6)
                       computerDice4.setImageResource(imageList[randomNum])
//                       compResultlist.add(randomNum+1)
                       compResultlist[index]=randomNum+1

                   }
                   else if (index==4){
                       randomNum=Random().nextInt(6)
                       computerDice5.setImageResource(imageList[randomNum])
//                       compResultlist.add(randomNum+1)
                       compResultlist[index]=randomNum+1

                   }
                }
                index++

            }


        }

scoreBtn.setOnClickListener{
    throwbtn.setEnabled(true)
    updateScore()
}


    }

        private fun updateScore() {
            rethrowCount=0
            playerScoreText = findViewById(R.id.playerScore)
            compScoreText = findViewById(R.id.ComputerScore)
            var scoreTotal=0
            var scoreTotalComp=0
            for (i in 0 until playerResultList.size){
              scoreTotal+= playerResultList[i]
            }


            for (j in 0 until compResultlist.size){
                scoreTotalComp += compResultlist[j]
            }

        // display the score
        playerScoreText.setText("Player score: " + scoreTotal)
            compScoreText.setText("Computer score: " + scoreTotalComp)

            if (scoreTotalComp>winningScore && scoreTotalComp>scoreTotal) {
                compCounter = compCounter+1
                val intent = Intent(this, WinnerActivity::class.java)

                intent.putExtra("winningScore", Integer.toString(scoreTotalComp))
                intent.putExtra("winner", "Computer")
                intent.putExtra("compCounter", Integer.toString(compCounter))
                intent.putExtra("playerCounter", Integer.toString(playerCounter))
                startActivity(intent)


            }
            if (scoreTotal>winningScore && scoreTotal>scoreTotalComp){
                val intent = Intent(this, WinnerActivity::class.java)
                playerCounter = playerCounter+1
                intent.putExtra("winningScore",Integer.toString(scoreTotal))
                intent.putExtra("winner", "Player")
                intent.putExtra("compCounter", Integer.toString(compCounter))
                intent.putExtra("playerCounter", Integer.toString(playerCounter))
                startActivity(intent)
            }
            if (scoreTotal>winningScore && scoreTotal == scoreTotalComp){
                rethrowBtn.visibility= View.INVISIBLE
            }


}





}