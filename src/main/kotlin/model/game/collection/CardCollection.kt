package model.game.collection

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import model.game.builder.PlayerBuilder.Companion.CARDS_IN_HAND
import model.game.builder.addToFlow
import model.game.builder.clear
import model.game.builder.removeFromFlow
import model.data.BasicCard
import model.data.ProvidesResources

open class CardCollection<T : BasicCard> {

  private val _cards: MutableStateFlow<MutableList<T>> = MutableStateFlow(mutableListOf())
  val cards = _cards.asStateFlow()

  /* ------------------ Add ------------------ */

  fun addAll(cards: List<T>) {
    _cards.addToFlow(cards)
  }

  fun add(card: T) {
    _cards.addToFlow(card)
  }

  /* ------------------ Remove ------------------ */

  fun clear(): List<T> {
    val all = cards.value
    _cards.clear()
    return all
  }

  fun remove(card: T): T {
    _cards.removeFromFlow(card)
    return card
  }

  fun removeAll(cards: List<T>): List<T> {
    _cards.removeFromFlow(cards)
    return cards
  }

  /* ------------------ Random ------------------ */

  fun random(): T? = _cards.value.randomOrNull()

  fun removeRandom(amount: Int): List<T> {
    val list = mutableListOf<T>()
    repeat(amount) {
      val card = removeRandom() ?: return@repeat
      list.add(card)
    }
    return list
  }

  fun removeRandom(): T? {
    val card = random() ?: return null
    _cards.removeFromFlow(card)
    return card
  }

  /* ------------------ Sizes ------------------ */

  fun size(): Int = cards.value.size

  fun drawableCards(): Int = if (size() < CARDS_IN_HAND) size() else CARDS_IN_HAND

  fun neededCards(): Int {
    val cardsLeft = CARDS_IN_HAND - size()
    return if (cardsLeft > 0) cardsLeft else 0
  }

  fun isFullHand(): Boolean = size() == CARDS_IN_HAND

  /* ------------------ Resources ------------------ */

  fun resources(): List<ProvidesResources> = _cards.value.filterIsInstance<ProvidesResources>()
}
