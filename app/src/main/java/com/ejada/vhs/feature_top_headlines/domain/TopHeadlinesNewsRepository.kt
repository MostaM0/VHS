package com.ejada.vhs.feature_top_headlines.domain

import com.ejada.vhs.core.domain.news_list.entity.NewsListResponse
import retrofit2.Response

interface TopHeadlinesNewsRepository {
    suspend fun getTopHeadlinesNews(
        country: String?,
        category: String?,
        page: Int,
    ): Response<NewsListResponse>
}