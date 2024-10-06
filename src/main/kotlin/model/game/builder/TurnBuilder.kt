package model.game.builder

import kotlinx.coroutines.flow.MutableStateFlow
import model.controller.GamePlayer

class TurnBuilder(
  private val playerOne: GamePlayer,
  private val playerTwo: GamePlayer,
) {
  val currentPlayer: MutableStateFlow<PlayerBuilder> = MutableStateFlow(PlayerBuilder(playerOne))
  val oppositePlayer: MutableStateFlow<PlayerBuilder> = MutableStateFlow(PlayerBuilder(playerTwo))
}