package com.example.kmm_demo.android.ui.screen.characters

import com.example.kmm_demo.shared.entity.Character

sealed class CharactersState {
    object Empty : CharactersState()
    object Loading : CharactersState()
    data class Data(val characters: List<Character>) : CharactersState()
    data class Error(val error: Throwable?) : CharactersState()
    object EmptyData : CharactersState()
}
