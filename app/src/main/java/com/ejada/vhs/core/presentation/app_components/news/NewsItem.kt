package com.ejada.vhs.core.presentation.app_components.news

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.ejada.vhs.core.domain.news_items.entity.Article
import com.ejada.vhs.core.presentation.compose_components.image.AsyncImage
import com.ejada.vhs.core.presentation.design_system.theme.VHSColors
import com.ejada.vhs.core.presentation.design_system.theme.VHSTypography
import com.ejada.vhs.core.util.time.toLocalTime


@Composable
fun NewsItem(
    modifier: Modifier = Modifier,
    article: Article?
) {
    ConstraintLayout(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        val (imgCover, txtTitle, txtPublishDate, txtSource) = createRefs()

        Box(
            modifier = modifier
                .padding(vertical = 4.dp)
                .constrainAs(imgCover) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
                .size(96.dp)
                .clip(
                    RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.BottomStart
        ) {
            AsyncImage(
                model = article?.urlToImage /*?: "https://cdn.abcotvs.com/dip/images/12910521_030323-wls-insect-img.jpg?w=1600"*/,
                requestBuilder = { crossfade(true) },
                contentDescription = "Cuisine image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            modifier = Modifier
                .constrainAs(txtTitle) {
                    top.linkTo(parent.top)
                    start.linkTo(imgCover.end)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .padding(5.dp)
                .wrapContentHeight()
                .padding(8.dp),
            text = article?.title ?: "",
            color = VHSColors.designSystem.Neutral30,
            style = VHSTypography.text14Bold
        )


        Text(
            modifier = Modifier
                .constrainAs(txtPublishDate) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(imgCover.end)
                }
                .padding(5.dp)
                .wrapContentHeight()
                .wrapContentWidth()
                .padding(8.dp),
            text = article?.publishedAt?.toLocalTime() ?: "",
            color = VHSColors.designSystem.Neutral30,
            style = VHSTypography.text10
        )


        Text(
            modifier = Modifier
                .constrainAs(txtSource) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
                .padding(5.dp)
                .wrapContentHeight()
                .wrapContentWidth()
                .padding(8.dp),
            text = article?.source?.name ?: "",
            color = VHSColors.designSystem.Neutral30,
            style = VHSTypography.text10
        )
    }
}