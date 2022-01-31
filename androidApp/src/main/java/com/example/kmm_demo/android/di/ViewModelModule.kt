package com.example.kmm_demo.android.di

import com.example.kmm_demo.android.ui.screen.characters.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        CharactersViewModel(get())
    }
}
