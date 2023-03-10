package com.ejada.vhs.feature_search_news.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import com.ejada.vhs.core.domain.news_items.entity.Article
import com.ejada.vhs.core.util.constants.ApiConstants.Companion.PAGINATION_PAGE_SIZE
import com.ejada.vhs.feature_search_news.data.remote.source.SearchNewsSource
import com.ejada.vhs.feature_search_news.domain.search_news.usecase.SearchNewsUseCase
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class SearchNewsViewModel @Inject constructor(
    private val searchNewsUseCase: SearchNewsUseCase
) : ViewModel() {

    fun searchNews(
        query: String?,
        language: String?,
        sortBy: String?,
    ): Flow<PagingData<Article>> {
        return Pager(PagingConfig(pageSize = PAGINATION_PAGE_SIZE)) {
            SearchNewsSource(
                searchNewsUseCase,
                query = query,
                language = language,
                sortBy = sortBy
            )
        }.flow.cachedIn(viewModelScope)
    }
}