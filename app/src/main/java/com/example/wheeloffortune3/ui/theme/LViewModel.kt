package com.example.wheeloffortune3.ui.theme

import androidx.lifecycle.ViewModel
import com.example.wheeloffortune3.data.GameData
import com.example.wheeloffortune3.model.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LViewModel : ViewModel() {
    private val state = MutableStateFlow(State())
    val state2: StateFlow<State> = state.asStateFlow()

    init {
        val word = makeStartWord()
        val hiddenWord = makeHiddenStartWord(word)




        state.update { t ->
            t.copy(concealedWord = hiddenWord, realWOrd = word)
        }
    }
    fun makeStartWord():String{
        val gameData=GameData()
        gameData.randomCategory()
        return gameData.currentWord

    }
    fun makeHiddenStartWord(string: String):String{
        var hiddenword=""
        for (letter in string) {
            hiddenword = hiddenword.plus("- ")

        }
        return hiddenword


    }

    fun guessedWord(input: String): Boolean {
        for (letter in state.value.realWOrd) {
            if (letter.toString() == input) {
                return true
            }
        }
        return false
    }

    fun addGuess(guess: Char) {
        var newCur = StringBuilder(state.value.concealedWord)

        if (guessedWord(guess.toString())) {
            for (i in 0..state.value.realWOrd.length) {
                if (guess == state.value.realWOrd.toCharArray()[i]) {
                    newCur.setCharAt(i, guess)
                }
            }
        }
        state.update { t -> t.copy(concealedWord = newCur.toString()) }


    }

}