/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.controller

import model.data.HeroCard
import model.data.TradeRowCard

data class GamePlayer(
  val name: String,
  val heroes: Set<HeroCard> = mutableSetOf(),
  val cards: List<TradeRowCard> = mutableListOf(),
) {
  companion object {
    fun playerOne() = GamePlayer("Player one")
    fun playerTwo() = GamePlayer("Player two")
  }

  fun addHero(heroCard: HeroCard): GamePlayer = copy(
    heroes = heroes.toMutableSet().apply { add(heroCard) }
  )

  fun addCard(tradeRowCard: TradeRowCard): GamePlayer = copy(
    cards = cards.toMutableList().apply { add(tradeRowCard) }
  )

  fun removeCard(tradeRowCard: TradeRowCard): GamePlayer = copy(
    cards = cards.toMutableList().apply { remove(tradeRowCard) }
  )

  fun eq(other: GamePlayer): Boolean = name == other.name
}
