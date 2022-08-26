package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private var _score = MutableLiveData<Int>(0)
    private var _currentWordCount = MutableLiveData<Int>(0)
    private val _currentScrambledWord = MutableLiveData<String>()
    val TAG = "GameFragment"

    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    val score: LiveData<Int> get() = _score
    val currentWordCount: LiveData<Int> get() = _currentWordCount
    val currentScrambledWord: LiveData<String> get() = _currentScrambledWord
    private val resultList:  MutableList<String> = mutableListOf()

    init {
        Log.d(TAG, "Game View Model is created!")
        getNextWord()
    }

    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()
        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord.value = String(tempWord)
            var resultString = _currentScrambledWord.value + ": " + currentWord+"\n"
            wordsList.add(currentWord)
            _currentWordCount.value = _currentWordCount.value?.inc()
            resultList.add(resultString)
        }
    }

    /*
    * Returns true if the current word count is less than MAX_NO_OF_WORDS.
    * Updates the next word.
    */
    fun nextWord(): Boolean {
        return if (currentWordCount.value!! < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    fun increaseScore() {
        _score.value = _score.value?.plus(SCORE_INCREASE)
    }

    fun isUserWordCorrect(enteredValue:String): Boolean {
        if(currentWord.equals(enteredValue,true)){
            increaseScore()
            return true
        }
        return false
    }

    /*
* Re-initializes the game data to restart the game.
*/
    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        wordsList.clear()
        resultList.clear()
        getNextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    fun getResultMessage(str:String):String{
        return str+"\n"+resultList.toString().replace("[","").replace("]","").replace(",","")
    }
}