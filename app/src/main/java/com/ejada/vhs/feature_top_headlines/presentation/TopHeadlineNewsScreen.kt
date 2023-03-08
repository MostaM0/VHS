package com.ejada.vhs.feature_top_headlines.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.ejada.vhs.R
import com.ejada.vhs.core.presentation.app_components.filter.FiltersList
import com.ejada.vhs.core.presentation.app_components.news.NewsItem
import com.ejada.vhs.core.presentation.compose_components.paging_state.PagingLoadingState
import com.ejada.vhs.core.presentation.design_system.theme.VHSColors
import com.ejada.vhs.core.presentation.design_system.theme.VHSTypography
import com.ejada.vhs.core.util.list.countryItems
import com.ejada.vhs.core.util.list.categoryItems

@Composable
fun TopHeadlineNewsScreen(
    modifier: Modifier = Modifier,
    viewModel: TopHeadlineNewsViewModel = hiltViewModel()
) {
    val country: MutableState<String?> = remember { mutableStateOf(null) }
    val category: MutableState<String?> = remember { mutableStateOf("general") }

    val countryList = remember { countryItems }
    val categoryList = remember { categoryItems }

    val topHeadlineList =
        viewModel.getTopHeadlinesNews(country = country.value, category = category.value)
            .collectAsLazyPagingItems()


    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(5.dp)
                .wrapContentHeight()
                .wrapContentWidth()
                .padding(8.dp),
            text = stringResource(id = R.string.top_headlines),
            color = VHSColors.designSystem.PrimaryText,
            style = VHSTypography.text18
        )
        LazyColumn {
            item {
                FiltersList(
                    filterText = stringResource(id = R.string.country),
                    filterState = country,
                    filterList = countryList
                )
            }
            item {
                FiltersList(
                    filterText = stringResource(id = R.string.category),
                    filterState = category,
                    filterList = categoryList
                )
            }

            if (topHeadlineList.itemCount > 0) {
                item {
                    Text(
                        modifier = Modifier
                            .padding(10.dp)
                            .wrapContentHeight()
                            .wrapContentWidth()
                            .padding(8.dp),
                        text = stringResource(id = R.string.top_headlines),
                        color = VHSColors.designSystem.Neutral30,
                        style = VHSTypography.text14
                    )
                }
                items(topHeadlineList.itemCount) {
                    NewsItem(article = topHeadlineList[it])
                }
            }

            item {
                PagingLoadingState(pagingItems = topHeadlineList)
            }
        }
    }

}