package views.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import model.builder.PlayerBuilder
import model.builder.TradeRowBuilder
import presentation.card.RenderBasicCard
import presentation.card.RenderTradeRowCard
import presentation.components.TopBar
import presentation.field.cards.CardColumn
import presentation.field.cards.CardRow
import presentation.field.cards.Deck

object TradeRowTestScreen : Screen {

  private val tradeRowBuilder = TradeRowBuilder()
  private val playerBuilder = PlayerBuilder()

  @Composable
  override fun Content() {
    val remainingCards by tradeRowBuilder.allCards.collectAsState()
    val currentTradeRow by tradeRowBuilder.currentCards.collectAsState()
    val playerCards by playerBuilder.deck.collectAsState()
    val playerHand by playerBuilder.hand.collectAsState()
    val playerGold by playerBuilder.gold.collectAsState()

    Column(
      modifier = Modifier.fillMaxSize()
    ) {
      TopBar {
        Button(
          onClick = {
            tradeRowBuilder.reset()
            playerBuilder.reset()
          },
          content = { Text("Reset") }
        )
        Button(
          onClick = {
            playerBuilder.onNewTurn()
            tradeRowBuilder.onNewTurn()
          },
          content = { Text("Next turn") }
        )
      }

      Row(modifier = Modifier.fillMaxWidth()) {

        Column(Modifier.weight(1f)) {
          CardRow(currentTradeRow, "Trade row") {
            RenderTradeRowCard(
              card = it,
              onClick = { tradeRowBuilder.buyCard(playerBuilder, it) }
            )
          }
          Spacer(Modifier.weight(1f))
          CardRow(playerHand, "Hand") {
            RenderBasicCard(it)
          }
          Deck(playerCards) {
            RenderBasicCard(it)
          }
        }
        Spacer(Modifier.width(10.dp))
        CardColumn(remainingCards.sortedBy { it.cost }) {
          RenderTradeRowCard(it)
        }
        Spacer(Modifier.width(10.dp))
        Column(modifier = Modifier.width(200.dp)) {
          Text("Remaining gold $playerGold")

        }
      }
    }
  }
}