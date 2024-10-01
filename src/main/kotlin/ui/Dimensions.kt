package ui

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.*

object Dimensions {

}

val LocalCardDimension: ProvidableCompositionLocal<CardDimension> = compositionLocalOf { CardDimension.Medium }

sealed interface CardDimension {
  val height: Dp
  val width: Dp
  val fontSize: TextUnit

  data object Large: CardDimension {
    override val height: Dp = 350.dp
    override val width: Dp = 250.dp
    override val fontSize: TextUnit = 10.sp
  }

  data object Medium: CardDimension {
    override val height: Dp = 252.dp
    override val width: Dp = 180.dp
    override val fontSize: TextUnit = 8.sp
  }

  data object Small: CardDimension {
    override val height: Dp = 200.dp
    override val width: Dp = 143.dp
    override val fontSize: TextUnit = 6.sp
  }

  fun dpSize(): DpSize = DpSize(width, height)

}