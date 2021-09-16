package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollDice()
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        //this is where the dice is being rolled
        val dice:Dice = Dice(6)
        val diceRoll = dice.roll()
        val diceTwo = Dice(6)
        val diceRollTwo = diceTwo.roll()
        //this is the id for the image button
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImageTwo:ImageView = findViewById(R.id.imageView2)

        //setting the correct dice
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //setting the correct dice
        val drawableResourceTwo = when (diceRollTwo) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        diceImage.setImageResource(drawableResource)
        diceImageTwo.setImageResource(drawableResourceTwo)

    }
}

class Dice(private val numSide: Int) {
    fun roll(): Int {
        return (1..numSide).random()
    }
}