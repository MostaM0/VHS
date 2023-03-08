package com.ejada.vhs.feature_top_headlines.data.remote

import com.ejada.vhs.core.domain.news_list.entity.NewsListResponse
import com.ejada.vhs.core.util.constants.ApiConstants.Companion.PAGINATION_PAGE_SIZE
import retrofit2.Response
import retrofit2.http.*

interface TopHeadlinesApi {

    @GET("top-headlines")
    suspend fun getTopHeadlinesNews(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int = PAGINATION_PAGE_SIZE
    ): Response<NewsListResponse>

}

