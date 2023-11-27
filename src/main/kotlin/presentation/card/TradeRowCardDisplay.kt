/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.card

import androidx.compose.runtime.Composable
import model.data.TradeRowCard
import ui.CardDimension

@Composable
fun TradeRowCardDisplay(
  card: TradeRowCard,
  cardDimension: CardDimension = CardDimension.Medium,
  onClick: (TradeRowCard) -> Unit = {},
  ) {
  CardDisplay(
    card,
    cardDimension = cardDimension,
    onClick = { onClick(card) },
    content = {

    }
  )
}