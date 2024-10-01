package model.data.starting

import model.data.Resource
import model.data.StartingCard

val startingGold = StartingCard(
  name = "gold",
  imageRes = "Gold.png",
  resource = Resource.Gold(1),
)

val startingGear = StartingCard(
  name = "Gear",
  imageRes = "Gear.png",
  resource = Resource.None,
)

