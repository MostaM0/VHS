package com.ejada.vhs.feature_top_headlines.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.ejada.vhs.feature_top_headlines.data.remote.TopHeadlinesApi
import com.ejada.vhs.feature_top_headlines.data.repository.TopHeadlinesNewsRepositoryImpl
import com.ejada.vhs.feature_top_headlines.domain.TopHeadlinesNewsRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TopHeadlinesNewsModule {

    @Singleton
    @Provides
    fun providesTopHeadlinesNewsRepository(topHeadlinesApi: TopHeadlinesApi): TopHeadlinesNewsRepository =
        TopHeadlinesNewsRepositoryImpl(topHeadlinesApi)

    @Singleton
    @Provides
    fun provideTopHeadlinesApi(retrofit: Retrofit): TopHeadlinesApi =
        retrofit.create(TopHeadlinesApi::class.java)
}