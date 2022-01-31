package com.example.kmm_demo.android.ui.screen.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmm_demo.shared.api.RickApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch

class CharactersViewModel(private val api: RickApi) : ViewModel() {
    private val _state: MutableLiveData<CharactersState> = MutableLiveData(CharactersState.EmptyData)
    val state: LiveData<CharactersState> = _state

    val intents = Channel<CharactersIntent>(Channel.UNLIMITED)

    init {
        handleIntent()
    }

    fun setIntent(intent: CharactersIntent) {
        viewModelScope.launch {
            intents.send(intent)
        }
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intents.consumeEach {
                when (it) {
                    is CharactersIntent.GetCharacters -> getCharacters()
                }
            }
        }
    }

    private fun getCharacters() {
        viewModelScope.launch {
            try {
                _state.value = CharactersState.Loading

                val characters = api.getAllCharacters().results
                if (characters.isEmpty()) {
                    _state.value = CharactersState.EmptyData
                } else {
                    _state.value = CharactersState.Data(characters)
                }
            } catch (exception: Throwable) {
                _state.value = CharactersState.Error(exception)
            }
        }
    }
}