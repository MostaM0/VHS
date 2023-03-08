package com.ejada.vhs.feature_top_headlines.domain.top_headlines.usecase

import com.ejada.vhs.core.di.qualifiers.IoDispatcher
import com.ejada.vhs.core.domain.common.usecase.ApiUseCase
import com.ejada.vhs.core.domain.news_list.entity.NewsListResponse
import com.ejada.vhs.feature_top_headlines.domain.TopHeadlinesNewsRepository
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Response
import javax.inject.Inject

class TopHeadlineNewsUseCase @Inject constructor(
    private val topHeadlinesNewsRepository: TopHeadlinesNewsRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : ApiUseCase<TopHeadlineNewsUseCase.Params, NewsListResponse>(
    ioDispatcher
) {
    override suspend fun execute(parameters: Params): Response<NewsListResponse> =
        topHeadlinesNewsRepository.getTopHeadlinesNews(
            parameters.country,
            parameters.category,
            parameters.page
        )

    data class Params(
        val country: String?,
        val category: String?,
        val page: Int,
    )
}
