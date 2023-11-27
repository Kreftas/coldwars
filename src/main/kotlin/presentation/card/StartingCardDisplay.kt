/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import presentation.card.components.resource_provider.EssenceProvider
import presentation.card.components.resource_provider.GoldProvider
import model.data.Resource
import model.data.StartingCard
import ui.CardDimension

@Composable
fun StartingCardDisplay(
  card: StartingCard,
  cardDimension: CardDimension = CardDimension.Medium,
  onClick: (StartingCard) -> Unit = {},
) {
  CardDisplay(
    card,
    cardDimension = cardDimension,
    detailed = false,
    onClick = { onClick(card) },
    content = {
      Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
      ) {
        when (val res = card.resource) {
          is Resource.Gold -> GoldProvider(res.amount)
          is Resource.Essence -> EssenceProvider(res.essence, res.amount)
          is Resource.MultiEssence -> {}
        }
      }
    }
  )
}