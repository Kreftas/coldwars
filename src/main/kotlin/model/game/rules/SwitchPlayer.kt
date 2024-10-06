package model.game.rules

import model.game.builder.TurnBuilder

data class SwitchPlayer(
  private val turnBuilder: TurnBuilder,
) : Rule {

  override suspend fun execute() {
    with(turnBuilder) {
      val current = currentPlayer.value
      val opposite = oppositePlayer.value
      oppositePlayer.value = current
      currentPlayer.value = opposite
    }
  }

  override suspend fun undo() {
    execute()
  }
}
