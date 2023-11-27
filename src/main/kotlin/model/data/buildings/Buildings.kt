/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.data.buildings

import model.data.Attribute
import model.data.BuildingAbility
import model.data.BuildingCard
import model.data.Essence

val Barracks = BuildingCard(
  name = "Barracks",
  points = 1,
  attribute = Attribute.Military,
  cost = 2,
  ability = BuildingAbility(
    name = "Siege",
    description = "Make one of your opponents buildings unusable for 2 turns",
    cost = listOf(Essence(Attribute.Military), Essence(Attribute.Military))
  )
)

val PeasantMarketplace = BuildingCard(
  name = "Peasant Marketplace",
  attribute = Attribute.Economic,
  points = 1,
  cost = 1,
  ability = BuildingAbility(
    name = "Bargain",
    description = "Trade or something",
    cost = listOf(Essence(Attribute.Economic))
  )
)

val CelestialTreasury = BuildingCard(
  name = "Celestial Treasury",
  attribute = Attribute.Economic,
  points = 5,
  cost = 5,
  ability = BuildingAbility(
    name = "Endless treasure",
    description = "Trade or something",
    cost = listOf(
      Essence(Attribute.Economic),
      Essence(Attribute.Economic),
      Essence(Attribute.Economic),
    )
  )
)