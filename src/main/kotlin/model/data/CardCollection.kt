package model.data

import model.data.buildings.*
import model.data.heroes.*
import model.data.items.*
import model.data.starting.startingGear
import model.data.starting.startingGold

/** All building cards. */
val buildingCards: List<BuildingCard> = listOf(
  Barracks, PeasantMarketplace, CelestialTreasury
)

/** All item cards. */
val itemCards: List<ItemCard> = listOf(
  CannonFodder, IonCannon, Purse, GoldDiggerSpade, DesertCaravan, FragileIndustry, GeyserFarm, Gulag,
  DairyOfLostWilhelmCook, MutualDefeat, WindFarm, SolitaryMight, DeepDwelling
)

/** All trade row cards. */
val allTradeRowCards: List<TradeRowCard> = listOf<TradeRowCard>(
  *buildingCards.toTypedArray(), *itemCards.toTypedArray()
)

/** All starting cards */
val startingCardsCollection: List<Starters> = listOf(
  startingGold, startingGold, startingGold, startingGold, startingGold,
  startingGold, startingGold, startingGold, startingGear, startingGear, startingGold
)

/** All heroes */
val heroCollection: List<HeroCard> = listOf(
  HeroDwarf, HeroGoblin, HeroHuman, HeroElf, HeroTroll, HeroOrc, HeroFairy, HeroGnome
)

