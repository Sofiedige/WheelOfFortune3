package com.example.wheeloffortune3

import com.example.wheeloffortune3.data.GameData
import com.example.wheeloffortune3.ui.theme.LViewModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun hidWord(){
        val model=LViewModel()
        println(model.makeHiddenStartWord("WORD"))
    }
    @Test
    fun startWord(){
        val string= LViewModel().makeStartWord()
        println("There should be a string under here")
        println(string)
    }
}