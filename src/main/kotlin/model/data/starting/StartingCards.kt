package model.data.starting

import model.data.Resource
import model.data.StartingCard

val startingGold = StartingCard(
  name = "gold",
  imageRes = "Gold.png",
  resources = listOf(
    Resource.GoldResource(1),
  )
)

val startingGear = StartingCard(
  name = "Gear",
  imageRes = "Gear.png",
  resources = emptyList(),
)

