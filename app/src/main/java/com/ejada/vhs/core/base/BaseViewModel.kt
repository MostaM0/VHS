package com.ejada.vhs.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    private val _uiState = MutableStateFlow<BaseViewState>(BaseViewState.Idle)
    val uiState = _uiState.asStateFlow()

    protected fun setState(state: BaseViewState) = safeLaunch {
        _uiState.emit(state)
    }

    protected fun safeLaunch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(handler, block = block)
    }

    private val handler = CoroutineExceptionHandler { _, exception ->
        _uiState.value = BaseViewState.Error(exception)
        // handleError(exception)
    }
}