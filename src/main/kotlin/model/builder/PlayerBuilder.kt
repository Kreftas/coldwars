/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.builder

import framework.CLog
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import model.data.*

class PlayerBuilder {

  companion object {
    private const val CARDS_IN_HAND = 5
  }

  private val delay = 500L

  private val scope = CoroutineScope(Dispatchers.Main)

  private var job: Job? = null

  /** The current essences that the user have access to. */
  val influence: MutableStateFlow<Int> = MutableStateFlow(0)

  /** The current essences that the user have access to. */
  val essences: MutableStateFlow<List<Essence>> = MutableStateFlow(emptyList())

  /** The current gold that the user have access to. */
  val gold: MutableStateFlow<Gold> = MutableStateFlow(0)

  /** The cards in the users deck. */
  val deck: MutableStateFlow<MutableList<BasicCard>> = MutableStateFlow(mutableListOf())

  /** The cards in the users discard pile. */
  val discard: MutableStateFlow<MutableList<BasicCard>> = MutableStateFlow(mutableListOf())

  /** The cards in the users hand. */
  val hand: MutableStateFlow<MutableList<BasicCard>> = MutableStateFlow(mutableListOf())

  /** The cards that the player have played this turn. */
  val played: MutableStateFlow<MutableList<BasicCard>> = MutableStateFlow(mutableListOf())

  init {
    reset()
  }

  /* ------------------ Public ------------------ */

  /** Resets the players cards. */
  fun reset() {
    job?.cancel()
    scope.launch {
      resetDecks()
      pickUpHand()
    }
  }

  /** Adds a new card to the deck and removes the gold cost. */
  fun onCardBought(tradeRowCard: TradeRowCard) {
    discard.addToFlow(tradeRowCard)
    gold.value -= tradeRowCard.cost
  }

  /** Picks up new cards and calculates the attributes. */
  fun onNewTurn() {
    job = scope.launch {
      CLog.d("New turn player")
      discardPlayedCards()
      discardHand()
      val cards = pickUpHand()
      pickUpRest(cards)
    }
  }

  fun playCard(card: BasicCard) {
    hand.removeFromFlow(card)
    played.addToFlow(card)
    calcAttributes()
  }

  /* ------------------ Suspend private ------------------ */

  /** Clears the deck and adds starting cards. */
  private fun resetDecks() {
    deck.clear()
    discard.clear()
    deck.addToFlow(startingCardsCollection)
  }

  /** Clears the hand and picks up random cards from the deck. */
  private suspend fun pickUpHand(): Int {
    hand.clear()
    val cardsToPickUp = cardsLeftToPickUp()
    pickUpCards(cardsToPickUp)
    return cardsToPickUp
  }

  private suspend fun pickUpRest(alreadyPickedUp: Int) {
    if (alreadyPickedUp == CARDS_IN_HAND) return

    shuffle()
    val cardsLeft = CARDS_IN_HAND - alreadyPickedUp
    pickUpCards(cardsLeft)
  }

  private suspend fun pickUpCards(amount: Int) {
    CLog.d("Picking up cards $amount")
    repeat(amount) {
      val card = deck.value.random()
      deck.removeFromFlow(card)
      hand.addToFlow(card)
    }
    delay(delay)
  }

  private suspend fun discardHand() {
    CLog.d("Discard hand")
    discard.addToFlow(hand.value)
    hand.clear()
    delay(delay)
  }

  private suspend fun discardPlayedCards() {
    CLog.d("Discard played cards")
    discard.addToFlow(played.value)
    played.clear()
    delay(delay)
  }

  private suspend fun shuffle() {
    CLog.d("Shuffle")
    deck.addToFlow(discard.value)
    discard.clear()
    delay(delay)
  }

  /* ------------------ Private ------------------ */

  /** Calculates all the attributes. */
  private fun calcAttributes() {
    val resources = played.value.filterIsInstance<ProvidesResources>()
    gold.value = resources.sumOf { it.resource.getGold() }
    essences.value = resources.flatMap { it.resource.essences() }
  }

  private fun cardsLeftToPickUp(): Int {
    val size = deck.value.size
    return if (size < CARDS_IN_HAND) size else CARDS_IN_HAND
  }
}