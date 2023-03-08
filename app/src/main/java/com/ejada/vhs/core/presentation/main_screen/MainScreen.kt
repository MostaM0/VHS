package com.ejada.vhs.core.presentation.main_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ejada.vhs.core.presentation.compose_components.navigation.BottomNavigationBar
import com.ejada.vhs.core.presentation.compose_components.navigation.Navigation
import com.ejada.vhs.core.presentation.design_system.theme.VHSColors


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        backgroundColor = VHSColors.designSystem.PrimaryBackground
    )
}