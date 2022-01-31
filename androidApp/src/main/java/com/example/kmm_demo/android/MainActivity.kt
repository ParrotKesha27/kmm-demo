package com.example.kmm_demo.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kmm_demo.android.databinding.ActivityMainBinding
import com.example.kmm_demo.android.ui.screen.Screen
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::bind)

    private val cicerone: Cicerone<Router> = Cicerone.create()
    private val router
        get() = cicerone.router
    private val navigator = AppNavigator(this, R.id.appContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        router.newRootScreen(Screen.characters())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        cicerone.getNavigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        cicerone.getNavigatorHolder().removeNavigator()
        super.onPause()
    }
}
