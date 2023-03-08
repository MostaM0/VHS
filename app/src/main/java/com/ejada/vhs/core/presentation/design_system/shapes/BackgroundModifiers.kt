package com.ejada.vhs.core.presentation.design_system.shapes

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.ejada.vhs.core.presentation.design_system.theme.VHSColors


fun Modifier.bgRounded8Neutral00StrokePrimary20() = composed {
    this.then(
        this
            .clip(RoundedCornerShape(8.dp))
            .border(
                width = 1.dp,
                color = VHSColors.designSystem.Primary20,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                color = VHSColors.designSystem.Neutral00,
            )
    )
}

fun Modifier.bgRounded8Neutral00StrokeNeutral10() = composed {
    this.then(
        this
            .clip(RoundedCornerShape(8.dp))
            .border(
                width = 1.dp,
                color = VHSColors.designSystem.Neutral10,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                color = VHSColors.designSystem.Neutral00,
            )
    )
}

fun Modifier.bgRounded8Primary00NonStroke() = composed {
    this.then(
        this
            .background(
                color = VHSColors.designSystem.Primary00.copy(alpha = 0.7f),
                shape = RoundedCornerShape(8.dp)
            )
    )
}