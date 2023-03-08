package com.ejada.vhs.core.presentation.compose_components.paging_state

import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.ejada.vhs.core.base.BaseViewState


@Composable
fun <T : Any> PagingLoadingState(
    pagingItems: LazyPagingItems<T>,
) {
    pagingItems.loadState.apply {
        when {
            refresh is LoadState.Loading -> {
                CustomLoadingIndicator(BaseViewState.Busy)
            }
            append is LoadState.Loading -> {
                CustomLoadingIndicator(BaseViewState.Busy)
            }
            append is LoadState.NotLoading -> {
                CustomLoadingIndicator(BaseViewState.Idle)
            }
            refresh is LoadState.NotLoading -> {
                CustomLoadingIndicator(BaseViewState.Idle)
            }
        }
    }
}