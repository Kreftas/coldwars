package model.game.rules

import model.game.builder.PlayerBuilder
import model.data.BasicCard

data class PickUpCard(
  val card: BasicCard,
  val player: PlayerBuilder,
) : Rule {

  override suspend fun execute() {
    with(player) {
      field.remove(card)
      hand.add(card)
    }
  }

  override suspend fun undo() {
    with(player) {
      hand.remove(card)
      field.add(card)
    }
  }
}
