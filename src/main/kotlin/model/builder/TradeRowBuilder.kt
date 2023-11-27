/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.builder

import kotlinx.coroutines.flow.MutableStateFlow
import model.data.TradeRowCard
import model.data.allTradeRowCards

class TradeRowBuilder {

  /** All cards that is available in the deck. */
  val allCards = MutableStateFlow<MutableList<TradeRowCard>>(mutableListOf())

  /** The cards currently in the trade row. */
  val currentCards = MutableStateFlow<MutableList<TradeRowCard>>(mutableListOf())

  init {
    reset()
  }

  fun onNewTurn() {
    addCardsToTradeRow()
  }

  fun buyCard(
    playerBuilder: PlayerBuilder,
    card: TradeRowCard,
  ): Boolean {
    val gold = playerBuilder.gold.value
    if (gold < card.cost) return false
    playerBuilder.onCardBought(card)
    currentCards.removeFromFlow(card)
    allCards.removeFromFlow(card)
    return true
  }

  fun reset() {
    allCards.value.clear()
    allCards.addToFlow(allTradeRowCards)
    addCardsToTradeRow()
  }

  private fun addCardsToTradeRow() {
    allCards.addToFlow(currentCards.value)
    currentCards.value.clear()
    repeat(5) {
      try {
        val card = allCards.value.random()
        currentCards.addToFlow(card)
        allCards.removeFromFlow(card)
      } catch (_: NoSuchElementException) {

      }
    }
  }



}