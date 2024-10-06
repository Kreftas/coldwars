package presentation.components

import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import ui.CardDimension

val LocalCardSize: ProvidableCompositionLocal<CardDimension> = compositionLocalOf { CardDimension.Small }

val LocalPlayerColor: ProvidableCompositionLocal<Color> = compositionLocalOf { Color.Blue }