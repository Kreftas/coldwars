/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.card

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import presentation.card.components.cost.GoldCost
import presentation.card.components.resource_provider.EssenceProvider
import presentation.card.components.resource_provider.GoldProvider
import presentation.card.components.resource_provider.MultiResourceProvider
import model.data.ItemCard
import model.data.Resource
import ui.CardDimension

@Composable
fun ItemCardDisplay(
  itemCard: ItemCard,
  cardDimension: CardDimension = CardDimension.Medium,
  onClick: () -> Unit = {},
) {
    CardDisplay(
      basicCard = itemCard,
      attribute = itemCard.attribute,
      detailed = true,
      cardDimension = cardDimension,
      onClick = onClick,
      costContent = {
        GoldCost(itemCard.cost)
      }
    ) {
      MultiResourceProvider(resource = itemCard.resource)
    }
}