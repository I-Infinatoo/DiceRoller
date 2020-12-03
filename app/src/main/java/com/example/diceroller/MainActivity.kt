package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * saved ref to the Button object in rollButton
         * linked button from mainActivity.xml
         **/

        val rollButton: Button = findViewById(R.id.button)

        /**
         * On click of the button rolldice will be called
         **/
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {

        /**
         * call Dice class with '6'
         **/

        val dice = Dice(6)

        /**
         * Update the imageView with the random number generated
         * And set the content description for screen reader
         **/

        val diceImage : ImageView  = findViewById(R.id.imageView)
        val diceImage2 : ImageView = findViewById(R.id.imageView2)

        val num  = dice.roll()
        val num2 = dice.roll()

        val image = when ( num ) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val image2 = when ( num2 ) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        diceImage.setImageResource(image)
        diceImage.contentDescription = num.toString()

        diceImage2.setImageResource(image2)
        diceImage2.contentDescription = num2.toString()
    }
}

class Dice(private val numSide: Int) {

    /**
     * roll will return the random number from [1,6]
     **/
    fun roll(): Int {
        return (1..numSide).random()
    }
}