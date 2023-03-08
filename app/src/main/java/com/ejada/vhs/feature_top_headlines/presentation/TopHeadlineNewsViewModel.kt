package com.ejada.vhs.feature_top_headlines.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ejada.vhs.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.ejada.vhs.core.domain.news_items.entity.Article
import com.ejada.vhs.core.util.constants.ApiConstants.Companion.PAGINATION_PAGE_SIZE
import com.ejada.vhs.feature_top_headlines.data.remote.source.TopHeadlineNewsSource
import com.ejada.vhs.feature_top_headlines.domain.top_headlines.usecase.TopHeadlineNewsUseCase
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class TopHeadlineNewsViewModel @Inject constructor(
    private val topHeadlineNewsUseCase: TopHeadlineNewsUseCase
) : BaseViewModel() {


    fun getTopHeadlinesNews(
        country: String?,
        category: String?,
    ): Flow<PagingData<Article>> =
        Pager(PagingConfig(pageSize = PAGINATION_PAGE_SIZE)) {
            TopHeadlineNewsSource(
                topHeadlineNewsUseCase,
                country = country,
                category = category
            )
        }.flow.cachedIn(viewModelScope)

}