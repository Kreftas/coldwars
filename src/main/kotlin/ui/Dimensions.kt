package ui

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Dimensions {

}

val LocalCardDimension: ProvidableCompositionLocal<CardDimension> = compositionLocalOf { CardDimension.Medium }

sealed interface CardDimension {
  val height: Dp
  val width: Dp
  val fontSize: TextUnit

  object Large: CardDimension {
    override val height: Dp = 350.dp
    override val width: Dp = 250.dp
    override val fontSize: TextUnit = 10.sp
  }

  object Medium: CardDimension {
    override val height: Dp = 252.dp
    override val width: Dp = 180.dp
    override val fontSize: TextUnit = 8.sp
  }

  object Small: CardDimension {
    override val height: Dp = 200.dp
    override val width: Dp = 143.dp
    override val fontSize: TextUnit = 6.sp
  }

}