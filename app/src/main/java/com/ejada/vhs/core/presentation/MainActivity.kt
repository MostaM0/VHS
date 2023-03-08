package com.ejada.vhs.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import com.ejada.vhs.core.presentation.design_system.theme.VHSTheme
import com.ejada.vhs.core.presentation.main_screen.MainScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VHSTheme(false) {
                MainScreen()
            }
        }
    }
}
