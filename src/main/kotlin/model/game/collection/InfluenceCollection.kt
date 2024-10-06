package model.game.collection

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import model.game.ResettableCollection

class InfluenceCollection: ResettableCollection {

  /** The current essences that the user have access to. */
  private val _influence: MutableStateFlow<Int> = MutableStateFlow(0)
  val influence = _influence.asStateFlow()

  fun increaseInfluence(amount: Int) {
    _influence.value += amount
  }

  override fun reset() {
    _influence.value = 0
  }

}