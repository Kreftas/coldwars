package model.game

import kotlinx.coroutines.flow.MutableStateFlow
import model.data.BasicCard
import model.game.rules.Rule

interface CardHolder {

  /** The cards in the users hand. */
  val hand: MutableStateFlow<MutableList<BasicCard>>

  // TODO: ItemCard
  /** The cards that the player have played this turn. */
  val played: MutableStateFlow<MutableList<BasicCard>>

}

interface Resettable {
  fun resetRule(): Rule
}

interface ResettableCollection {
  fun reset()
}