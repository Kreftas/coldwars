package model.game.rules.play

import model.data.Starters
import model.game.builder.PlayerBuilder
import model.game.rules.Rule

data class StarterCardPlayed(
  val card: Starters,
  val player: PlayerBuilder,
) : Rule {

  override suspend fun execute() {
    with(player) {
      gold.increase(card.gold())
    }
  }

  override suspend fun undo() {}
}