/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.card

import androidx.compose.runtime.Composable
import model.data.BasicCard
import model.data.BuildingCard
import model.data.ItemCard
import model.data.StartingCard
import model.data.TradeRowCard
import ui.CardDimension

@Composable
fun RenderTradeRowCard(
  card: TradeRowCard,
  cardDimension: CardDimension = CardDimension.Medium,
  onClick: () -> Unit = {},
) {
  when (card) {
    is ItemCard -> ItemCardDisplay(card, cardDimension, onClick)
    is BuildingCard -> BuildingCardDisplay(card, cardDimension, onClick = onClick)
    else -> {}
  }
}

@Composable
fun RenderBasicCard(
  card: BasicCard,
  cardDimension: CardDimension = CardDimension.Medium,
  onClick: () -> Unit = {},
) {
  when (card) {
    is ItemCard -> ItemCardDisplay(card, cardDimension, onClick)
    is BuildingCard -> BuildingCardDisplay(card, cardDimension, onClick = onClick)
    is StartingCard -> StartingCardDisplay(card, cardDimension, onClick = { onClick() })
    else -> {}
  }
}