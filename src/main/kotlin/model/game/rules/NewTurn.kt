package model.game.rules

import framework.CLog
import model.game.builder.PlayerBuilder
import model.game.builder.TurnBuilder

data class NewTurn(
  private val turnBuilder: TurnBuilder,
  private val player: PlayerBuilder,
) : Rule {

  override suspend fun execute() {
    player.gold.reset()
    player.essence.reset()
    DrawHand(player).execute()
//    SwitchPlayer(turnBuilder).execute()
  }

  override suspend fun undo() {
    CLog.d("Not yet implemented")
  }
}
