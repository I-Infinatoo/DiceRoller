package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

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
         * and pass the returned value to the textView widget
         **/
        val dice = Dice(6)
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = dice.roll().toString()

    }
}

class Dice(private val numSide: Int) {

    /**
     * roll will return the random number from [1,6] and return it
     **/
    fun roll(): Int {
        return (1..numSide).random()
    }
}