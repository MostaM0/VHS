package com.ejada.vhs.core.presentation.compose_components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ejada.vhs.feature_search_news.presentation.SearchNewsScreen
import com.ejada.vhs.feature_top_headlines.presentation.TopHeadlineNewsScreen


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.TopHeadline.screen.route) {
        composable(NavigationItem.SearchNews.screen.route) {
            SearchNewsScreen()
        }
        composable(NavigationItem.TopHeadline.screen.route) {
            TopHeadlineNewsScreen()
        }
    }
}