package model.data

import model.data.buildings.Barracks
import model.data.buildings.CelestialTreasury
import model.data.buildings.PeasantMarketplace
import model.data.heroes.HeroDwarf
import model.data.heroes.HeroElf
import model.data.heroes.HeroFairy
import model.data.heroes.HeroGnome
import model.data.heroes.HeroGoblin
import model.data.heroes.HeroHuman
import model.data.heroes.HeroOrc
import model.data.heroes.HeroTroll
import model.data.items.CogWheel
import model.data.items.DairyOfLostWilhelmCook
import model.data.items.GoldDiggerSpade
import model.data.items.Hammer
import model.data.items.IonCannon
import model.data.items.OilCan
import model.data.items.Pamphlet
import model.data.items.Pistol
import model.data.items.Purse
import model.data.items.RustySword

data class AbilityConfig(
  override val name: String,
  override val description: String,
) : Ability

data class SimpleAbilityConfig(
  override val types: Set<Resource>
) : ResourceAbility

object StartingGold : StartingCard {
  override val resource: Resource = Resource.Gold(1)
}

object StartingEssenceMilitary : StartingCard {
  override val resource: Resource = Resource.Essence(1, Essence(Attribute.Military))
}

object TradeRowTest : TradeRowCard {
  override val name: String = "Test presentation.card"
  override val cost: Int = 1
}

val buildingCards = listOf(
  Barracks,  PeasantMarketplace, CelestialTreasury
)

val itemCards = listOf(
  RustySword, IonCannon, Purse, GoldDiggerSpade, Hammer, Pistol, CogWheel, OilCan,
  DairyOfLostWilhelmCook, Pamphlet
)

val allTradeRowCards = listOf<TradeRowCard>(
  *buildingCards.toTypedArray(), *itemCards.toTypedArray()
)

/** All starting cards */
val startingCardsCollection = listOf(
  StartingEssenceMilitary, StartingGold, StartingGold, StartingGold, StartingGold,
  StartingGold, StartingGold, StartingGold, StartingGold, StartingGold,
)

/** All heroes */
val heroCollection: List<HeroCard> = listOf(
  HeroDwarf, HeroGoblin, HeroHuman, HeroElf, HeroTroll, HeroOrc, HeroFairy, HeroGnome
)

