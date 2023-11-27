/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.data.items

import model.data.Attribute
import model.data.Essence
import model.data.ItemCard
import model.data.Resource

val RustySword = ItemCard(
  name = "Rusty sword",
  attribute = Attribute.Military,
  cost = 1,
  resource = Resource.MultiEssence(listOf(
    Essence(Attribute.Military)
  ))
)

val Hammer = ItemCard(
  name = "Hammer",
  attribute = Attribute.Military,
  cost = 1,
  resource = Resource.Gold(1)
)

val Pistol = ItemCard(
  name = "Pistol",
  attribute = Attribute.Military,
  cost = 1,
  resource = Resource.MultiEssence(listOf(Attribute.Military))
)

val CogWheel = ItemCard(
  name = "Cog wheel",
  attribute = Attribute.Technology,
  cost = 1,
  resource = Resource.MultiEssence(listOf(Attribute.Technology))
)

val OilCan = ItemCard(
  name = "Oil can",
  attribute = Attribute.Technology,
  cost = 1,
  resource = Resource.MultiEssence(listOf(Attribute.Technology))
)

val Pamphlet = ItemCard(
  name = "Pamphlet",
  attribute = Attribute.Diplomacy,
  cost = 1,
  resource = Resource.MultiEssence(listOf(Attribute.Diplomacy))
)


val DairyOfLostWilhelmCook = ItemCard(
  name = "Lost diary of Wilhelm Cook",
  attribute = Attribute.Diplomacy,
  cost = 4,
  resource = Resource.MultiEssence(listOf(
    Attribute.Technology,
    Attribute.Diplomacy,
    Attribute.Diplomacy,
  ))
)



val IonCannon = ItemCard(
  name = "Ion canon",
  attribute = Attribute.Military,
  cost = 4,
  resource = Resource.MultiEssence(listOf(
    Essence(Attribute.Military),
    Essence(Attribute.Military),
    Essence(Attribute.Technology),
  ))
)


val Purse = ItemCard(
  name = "Purse",
  attribute = Attribute.Economic,
  cost = 1,
  resource = Resource.MultiEssence(listOf(
    Essence(Attribute.Economic)
  ))
)

val GoldDiggerSpade = ItemCard(
  name = "Gold digger's space",
  attribute = Attribute.Economic,
  cost = 4,
  resource = Resource.MultiEssence(listOf(
    Essence(Attribute.Economic),
    Essence(Attribute.Economic),
    Essence(Attribute.Economic),
  ))
)

