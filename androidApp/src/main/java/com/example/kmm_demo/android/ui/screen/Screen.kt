package com.example.kmm_demo.android.ui.screen

import com.example.kmm_demo.android.ui.screen.characters.CharactersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screen {
    fun characters() = FragmentScreen {
        CharactersFragment.newInstance()
    }
}
