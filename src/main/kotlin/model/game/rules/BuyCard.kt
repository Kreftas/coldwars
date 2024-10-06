package model.game.rules

import framework.CLog
import model.game.builder.PlayerBuilder
import model.game.builder.TradeRowBuilder
import model.data.BasicCard
import model.data.TradeRowCard

sealed class BuyCard(
  open val card: BasicCard,
  open val player: PlayerBuilder,
  open val tradeRow: TradeRowBuilder,
) : Rule


data class BuyTradeRowCard(
  override val card: TradeRowCard,
  override val player: PlayerBuilder,
  override val tradeRow: TradeRowBuilder,
) : BuyCard(card, player, tradeRow) {

  override suspend fun execute() {
    if (!player.gold.canBuyCard(card)) return

    with (player) {
      gold.payFor(card)
      discard.add(card)
    }

    tradeRow.row.remove(card)
  }

  override suspend fun undo() {
    CLog.d("Not yet implemented")
  }
}