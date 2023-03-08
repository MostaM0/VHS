package com.ejada.vhs.core.base

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import com.ejada.vhs.core.presentation.compose_components.paging_state.CustomLoadingIndicator


@Composable
fun BaseComposable(
    modifier: Modifier = Modifier,
    viewModel: BaseViewModel = hiltViewModel(),
    pageContent: @Composable () -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        pageContent()
        CustomLoadingIndicator(uiState)
    }

}
