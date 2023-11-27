/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.card

import androidx.compose.runtime.Composable
import presentation.card.components.ComplexAbilityDisplay
import presentation.card.components.cost.GoldCost
import model.data.BuildingAbility
import model.data.BuildingCard
import ui.CardDimension

@Composable
fun BuildingCardDisplay(
  buildingCard: BuildingCard,
  cardDimension: CardDimension = CardDimension.Medium,
  onAbilityClicked: (BuildingAbility) -> Unit = {},
  onClick: () -> Unit = {},
) {
    CardDisplay(
      basicCard = buildingCard,
      attribute = buildingCard.attribute,
      detailed = true,
      cardDimension = cardDimension,
      onClick = onClick,
      costContent = {
        GoldCost(buildingCard.cost)
      }
    ) {
      ComplexAbilityDisplay(buildingCard.ability) {
        onAbilityClicked(buildingCard.ability)
      }
    }
}