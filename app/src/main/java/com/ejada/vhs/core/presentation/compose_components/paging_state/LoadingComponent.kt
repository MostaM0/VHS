package com.ejada.vhs.core.presentation.compose_components.paging_state

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.ejada.vhs.R
import com.ejada.vhs.core.base.BaseViewState
import com.ejada.vhs.core.presentation.design_system.theme.VHSColors
import com.ejada.vhs.core.presentation.design_system.theme.VHSTypography


@Composable
fun CustomLoadingIndicator(state: BaseViewState) {
    when (state) {
        BaseViewState.Idle -> {}
        BaseViewState.Busy -> {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie_loader))
            val progress by animateLottieCompositionAsState(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                speed = 2f
            )

            Box(modifier = Modifier.fillMaxWidth()) {
                LottieAnimation(
                    modifier = Modifier
                        .height(32.dp)
                        .align(Alignment.Center),
                    composition = composition,
                    progress = progress,

                    )
            }
        }
        is BaseViewState.Error -> {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .padding(5.dp)
                        .wrapContentHeight()
                        .wrapContentWidth()
                        .padding(8.dp)
                        .align(Alignment.Center),
                    text = stringResource(id = R.string.some_thing_went_wrong),
                    color = VHSColors.designSystem.PrimaryText,
                    style = VHSTypography.text12
                )
            }
        }
    }
}