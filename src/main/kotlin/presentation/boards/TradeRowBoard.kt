package presentation.boards

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import framework.OnAction
import model.game.builder.TradeRowBuilder
import presentation.card.CardMould
import presentation.components.LocalPlayerColor
import presentation.field.areas.TradeRowArea
import presentation.field.cards.CardRow
import views.playground.TradeRowTestScreen.Action

@Composable
fun TradeRowBoard(
  tradeRowBuilder: TradeRowBuilder,
  cityTradeRowBuilder: TradeRowBuilder,
  onAction: OnAction<Action>,
) {
  val currentTradeRow by tradeRowBuilder.row.cards.collectAsState()
  val cityTradeRow by cityTradeRowBuilder.row.cards.collectAsState()

  CompositionLocalProvider(LocalPlayerColor provides MaterialTheme.colorScheme.outline) {
    TradeRowArea(
      tradeRow = {
        CardRow(currentTradeRow) {
          CardMould(it) {
            onAction(Action.BuyCard(it))
          }
        }
      },
      cityTradeRow = {
        CardRow(cityTradeRow) {
          CardMould(it) {
            onAction(Action.BuyCard(it))
          }
        }
      }
    )
  }
}