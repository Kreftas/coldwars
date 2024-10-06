package model.game.collection

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import model.data.Gold
import model.data.TradeRowCard
import model.game.ResettableCollection

class GoldCollection: ResettableCollection {

  /** The current gold that the user have access to. */
  private val _gold: MutableStateFlow<Gold> = MutableStateFlow(0)
  val gold = _gold.asStateFlow()

  fun get(): Gold = gold.value

  fun canBuyCard(card: TradeRowCard) = _gold.value >= card.cost

  fun payFor(card: TradeRowCard) {
    _gold.value -= card.cost
  }

  fun update(amount: Int) {
    _gold.value = amount
  }

  fun increase(amount: Int) {
    _gold.value += amount
  }

  override fun reset() {
    _gold.value = 0
  }
}