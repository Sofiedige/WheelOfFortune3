package com.example.wheeloffortune3.data

import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

class GameData() {
    //categories

    val vegetables = listOf("Vegetable","celery", "avocado", "cauliflower", "carrot","spinach","peber","broccoli","artichoke","potatoes","pumpkin")
    val animals = listOf("Animal","dog", "cat", "snail", "dolphin","jellyfish","cow","horse","chicken","snake","mountain lion")
    val desserts = listOf("Dessert","cheesecake", "icecream", "sex", "cookies","otello cake","fruit mix","candy","chocolate cake","brownie","ris ala mande")

    val categories = listOf(vegetables, animals, desserts)

    var currentWord = " "

    val wheelData = listOf(
        "fallit","100", "100", "100", "100", "200", "300", "400", "500"
    )

    fun spinData(): String {
        val ran = (0..9).random()
        return wheelData[ran]

    }

    fun randomCategory(): String {
        val ran = (0..3).random()
        val wordRan = (1..10).random()
        currentWord = categories[ran][wordRan]
        //2d liste
        return categories[ran][0]
    }

    fun spinWheel(){
        return
    }

    fun guessedWord(input: String): Boolean{
        for (letter in currentWord){
            if (letter.toString()== input){
                return true
            }
        }
        return false
    }

    fun addGuess(guess: Char,word : String, current : String): String {
        var newCur = StringBuilder(current)

        if(guessedWord(guess.toString())) {
            for (i in 0..word.length) {
                if (guess == word.toCharArray()[i]) {
                    newCur.setCharAt(i, guess)
                }
            }
        }

        return newCur.toString()

    }



/*
    fun findCurrentWord(): String {
        val ran =(0..3).random()
        //categories.value = categories[1][ran]
    }

 */

}