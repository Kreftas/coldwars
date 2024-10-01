package presentation.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import model.data.*
import ui.CardDimension

@Composable
fun CardMould(
  card: BasicCard,
  size: CardDimension = CardDimension.Small,
  onClick: () -> Unit = {},
) {
  when (card) {
    is HeroCard -> ImageCard(card, size, onClick)
    is Starters -> ImageCard(card, size, onClick)
    is BuildingCard -> ImageCard(card, size, onClick)
    is ItemCard -> ItemCardMould(card, size, onClick)
  }
}


@Composable
fun ImageCard(
  card: BasicCard,
  size: CardDimension = CardDimension.Small,
  onClick: () -> Unit = {},
) {
  Image(
    painter = painterResource(card.imageRes),
    contentDescription = null,
    modifier = Modifier
      .size(size.dpSize())
      .clickable { onClick() }
  )
}