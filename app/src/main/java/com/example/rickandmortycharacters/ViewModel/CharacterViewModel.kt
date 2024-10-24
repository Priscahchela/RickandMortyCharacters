package com.example.rickandmortycharacters.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycharacters.CharacterResult
import com.example.rickandmortycharacters.RetrofitInstance
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val _characters = MutableLiveData<List<CharacterResult>>()
    val characters: LiveData<List<CharacterResult>> = _characters


    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            val response = RetrofitInstance.api.getCharacters()
            if (response.isSuccessful) {
                response.body()?.let { CharacterResponse ->
                    _characters.postValue(CharacterResponse.results)  // Post the list of characters
                }
            }
        }
    }
}
