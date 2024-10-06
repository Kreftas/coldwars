package model.game.rules

import framework.CLog
import model.game.builder.PlayerBuilder
import model.game.builder.moveTo
import model.game.gameDelay

data class DrawHand(
  private val player: PlayerBuilder,
) : Rule {

  override suspend fun execute() {
    with(player) {
      field.clear().moveTo(discard)
      hand.clear().moveTo(discard)
      gameDelay()
      CLog.d("Moving ${deck.drawableCards()} from deck to hand with deck size ${deck.size()}")
      deck
        .removeRandom(deck.drawableCards())
        .moveTo(hand)
      gameDelay()

      if (!hand.isFullHand()) {
        CLog.d("Hand is not full, needed cards ${hand.neededCards()}")
        discard.clear().moveTo(deck)
        gameDelay()
        deck
          .removeRandom(hand.neededCards())
          .moveTo(hand)
      }
    }
  }

  override suspend fun undo() {
    CLog.d("Not yet implemented")
  }
}
