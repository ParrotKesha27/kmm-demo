package com.example.kmm_demo.android

import android.app.Application
import com.example.kmm_demo.android.di.viewModelModule
import com.example.kmm_demo.shared.di.initKoin
import org.koin.android.ext.koin.androidContext

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initDI()
    }

    private fun initDI() {
        initKoin {
            androidContext(this@App)
            modules(listOf(viewModelModule))
        }
    }
}