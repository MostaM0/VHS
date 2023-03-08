package com.ejada.vhs.feature_top_headlines.data.repository

import com.ejada.vhs.core.domain.news_list.entity.NewsListResponse
import com.ejada.vhs.feature_top_headlines.data.remote.TopHeadlinesApi
import com.ejada.vhs.feature_top_headlines.domain.TopHeadlinesNewsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class TopHeadlinesNewsRepositoryImpl @Inject constructor(
    private val topHeadlinesApi: TopHeadlinesApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : TopHeadlinesNewsRepository {

    override suspend fun getTopHeadlinesNews(
        country: String?,
        category: String?,
        page: Int
    ): Response<NewsListResponse> =
        withContext(ioDispatcher) {
            topHeadlinesApi.getTopHeadlinesNews(
                country = country,
                category = category,
                page = page
            )
        }
}