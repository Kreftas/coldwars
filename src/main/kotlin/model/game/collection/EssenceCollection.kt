package model.game.collection

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import model.data.Essence
import model.game.ResettableCollection

class EssenceCollection: ResettableCollection {

  /** The current essences that the user have access to. */
  private val _essences: MutableStateFlow<List<Essence>> = MutableStateFlow(emptyList())
  val essences = _essences.asStateFlow()

  fun updateEssence(essence: List<Essence>) {
    _essences.value = essence
  }

  fun increase(essence: List<Essence>) {
    _essences.value += essence
  }

  override fun reset() {
    _essences.value = emptyList()
  }

}