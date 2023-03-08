package com.ejada.vhs.core.base

sealed interface BaseViewState {
    object Busy : BaseViewState
    object Idle : BaseViewState
    data class Error(val throwable: Throwable) : BaseViewState
}
