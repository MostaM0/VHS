package com.ejada.vhs.feature_search_news.data.remote

import com.ejada.vhs.core.domain.news_list.entity.NewsListResponse
import com.ejada.vhs.core.util.constants.ApiConstants.Companion.PAGINATION_PAGE_SIZE
import retrofit2.Response
import retrofit2.http.*

interface SearchNewsApi {

    @GET("everything")
    suspend fun searchNews(
        @Query("q") query: String?,
        @Query("language") language: String?,
        @Query("sortBy") sortBy: String?,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int = PAGINATION_PAGE_SIZE
    ): Response<NewsListResponse>

}