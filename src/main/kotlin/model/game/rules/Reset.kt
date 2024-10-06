package model.game.rules

import framework.CLog
import model.game.builder.PlayerBuilder
import model.game.builder.TradeRowBuilder
import model.game.builder.moveTo
import model.data.Starters
import model.data.TradeRowCard
import model.game.Resettable

class ResetAll(private vararg val resettable: Resettable) : Rule {

  override suspend fun execute() {
    resettable
      .map { it.resetRule() }
      .forEach { rule ->
        rule.execute()
      }
  }

  override suspend fun undo() {
    CLog.d("Not yet implemented")
  }
}

/* ------------------ Player reset ------------------ */

data class PlayerReset(
  val player: PlayerBuilder,
  val cards: List<Starters>,
) : Rule {

  override suspend fun execute() {
    with(player) {
      all.forEach { it.clear() }
      resources.forEach { it.reset() }
      deck.addAll(cards)
      DrawHand(this).execute()
    }
  }

  override suspend fun undo() {
    CLog.d("Not yet implemented")
  }
}

/* ------------------ Trade row reset ------------------ */

data class TradeRowReset(
  val tradeRow: TradeRowBuilder,
  val cards: List<TradeRowCard>,
) : Rule {

  override suspend fun execute() {
    with(tradeRow) {
      deck.clear()
      row.clear()
      deck.addAll(cards)
      deck.removeRandom(5).moveTo(row)
    }
  }

  override suspend fun undo() {
    CLog.d("Not yet implemented")
  }
}