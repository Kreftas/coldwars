/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.data.items

import model.data.Attribute
import model.data.Essence
import model.data.ItemCard
import model.data.Resource

val VaultEngineering = ItemCard(
  name = "V",
  imageRes = "VaultEngineering.png",
  attribute = Attribute.Technology,
  cost = 1,
  resource = Resource.None
)

val CannonFodder = ItemCard(
  name = "Rusty sword",
  imageRes = "CannonFodder.png",
  attribute = Attribute.Military,
  cost = 1,
  resource = Resource.EssenceResource(listOf(
    Essence(Attribute.Military)
  ))
)

val DesertCaravan = ItemCard(
  name = "Hammer",
  imageRes = "DesertCaravan.png",
  attribute = Attribute.Military,
  cost = 1,
  resource = Resource.Gold(1)
)

val FragileIndustry = ItemCard(
  name = "Pistol",
  imageRes = "FragileIndustry.png",
  attribute = Attribute.Military,
  cost = 1,
  resource = Resource.EssenceResource(listOf(Attribute.Military))
)

val GeyserFarm = ItemCard(
  name = "Cog wheel",
  imageRes = "GeyserFarm.png",
  attribute = Attribute.Technology,
  cost = 1,
  resource = Resource.EssenceResource(listOf(Attribute.Technology))
)

val Gulag = ItemCard(
  name = "Oil can",
  imageRes = "Gulag.png",
  attribute = Attribute.Technology,
  cost = 1,
  resource = Resource.EssenceResource(listOf(Attribute.Technology))
)

val MutualDefeat = ItemCard(
  name = "Pamphlet",
  imageRes = "MutualDefeat.png",
  attribute = Attribute.Diplomacy,
  cost = 1,
  resource = Resource.EssenceResource(listOf(Attribute.Diplomacy))
)

val SolitaryMight = ItemCard(
  name = "Pamphlet",
  imageRes = "SolitaryMight.png",
  attribute = Attribute.Diplomacy,
  cost = 1,
  resource = Resource.EssenceResource(listOf(Attribute.Diplomacy))
)

val WindFarm = ItemCard(
  name = "Pamphlet",
  imageRes = "WindFarm.png",
  attribute = Attribute.Diplomacy,
  cost = 1,
  resource = Resource.EssenceResource(listOf(Attribute.Diplomacy))
)

val DeepDwelling = ItemCard(
  name = "Pamphlet",
  imageRes = "DeepDwelling.png",
  attribute = Attribute.Diplomacy,
  cost = 1,
  resource = Resource.EssenceResource(listOf(Attribute.Diplomacy))
)

val DairyOfLostWilhelmCook = ItemCard(
  name = "Lost diary of Wilhelm Cook",
  imageRes = "CardMould-12.png",
  attribute = Attribute.Diplomacy,
  cost = 4,
  resource = Resource.EssenceResource(listOf(
    Attribute.Technology,
    Attribute.Diplomacy,
    Attribute.Diplomacy,
  ))
)

val IonCannon = ItemCard(
  name = "Ion canon",
  imageRes = "CardMould-13.png",
  attribute = Attribute.Military,
  cost = 4,
  resource = Resource.EssenceResource(listOf(
    Essence(Attribute.Military),
    Essence(Attribute.Military),
    Essence(Attribute.Technology),
  ))
)


val Purse = ItemCard(
  name = "Purse",
  imageRes = "CardMould-14.png",
  attribute = Attribute.Economic,
  cost = 1,
  resource = Resource.EssenceResource(listOf(
    Essence(Attribute.Economic)
  ))
)

val GoldDiggerSpade = ItemCard(
  name = "Gold digger's space",
  imageRes = "CardMould-15.png",
  attribute = Attribute.Economic,
  cost = 4,
  resource = Resource.EssenceResource(listOf(
    Essence(Attribute.Economic),
    Essence(Attribute.Economic),
    Essence(Attribute.Economic),
  ))
)

