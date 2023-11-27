/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.builder

import kotlinx.coroutines.flow.MutableStateFlow
import model.data.BasicCard
import model.data.Gold
import model.data.StartingCard
import model.data.StartingGold
import model.data.TradeRowCard

class PlayerBuilder {

  companion object {
    private const val CARDS_IN_HAND = 5
  }

  private val incGold = 5

  /** The current gold that the user have access to. */
  val gold = MutableStateFlow<Gold>(0)

  /** The cards in the users deck. */
  val deck = MutableStateFlow<MutableList<BasicCard>>(mutableListOf())

  /** The cards in the users hand. */
  val hand = MutableStateFlow<MutableList<BasicCard>>(mutableListOf())

  init {
    reset()
  }

  fun reset() {
    gold.value = incGold
    addStartingCardsToDeck()
    pickUpHand()
  }

  fun onCardBought(tradeRowCard: TradeRowCard) {
    deck.addToFlow(tradeRowCard)
    gold.value -= tradeRowCard.cost
  }

  fun onNewTurn() {
    gold.value = incGold
    pickUpHand()
  }

  private fun addStartingCardsToDeck() {
    deck.value.clear()
    deck.addToFlow(listOf<StartingCard>(
      StartingGold, StartingGold, StartingGold, StartingGold, StartingGold,
      StartingGold, StartingGold, StartingGold, StartingGold, StartingGold,
    ))
  }

  private fun pickUpHand() {
    hand.value.clear()
    repeat(CARDS_IN_HAND) {
      hand.addToFlow(deck.value.random())
    }
  }


}