package views.test

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import model.builder.PlayerBuilder
import model.builder.TradeRowBuilder
import model.data.BasicCard
import presentation.card.CardMould
import model.data.itemCards
import model.data.starting.startingGold
import presentation.card.EssenceRow
import presentation.field.areas.PlayerArea
import presentation.field.areas.TradeRowArea
import presentation.scaffold.TopBar
import presentation.field.cards.CardRow
import presentation.field.cards.Deck

object TradeRowTestScreen : Screen {

  private val tradeRowBuilder = TradeRowBuilder()
  private val playerBuilder = PlayerBuilder()

  @Composable
  override fun Content() {
    val remainingCards by tradeRowBuilder.allCards.collectAsState()
    val currentTradeRow by tradeRowBuilder.currentCards.collectAsState()
    val playerCards: MutableList<BasicCard> by playerBuilder.deck.collectAsState()
    val playerHand: MutableList<BasicCard> by playerBuilder.hand.collectAsState()
    val playerPlayedCards: MutableList<BasicCard> by playerBuilder.played.collectAsState()
    val playerDiscard: MutableList<BasicCard> by playerBuilder.discard.collectAsState()
    val playerGold by playerBuilder.gold.collectAsState()
    val playerEssence by playerBuilder.essences.collectAsState()
    val playerInfluence by playerBuilder.influence.collectAsState()

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


      TradeRowArea(currentTradeRow) {
        tradeRowBuilder.buyCard(playerBuilder, it)
      }

      Spacer(Modifier.weight(1f))

      PlayerArea(
        deck = {
          Deck(playerCards) {
            CardMould(it)
          }
        },
        discard = {
          Deck(playerDiscard) {
            CardMould(it)
          }
        },
        hand = {
          CardRow(playerHand) {
            CardMould(it) {
              playerBuilder.playCard(it)
            }
          }
        },
        played = {
          CardRow(playerPlayedCards) {
            CardMould(it)
          }
        },
        status = {
          Text("Influence: $playerInfluence")
          Text("Gold: $playerGold")
          EssenceRow(playerEssence)
        }
      )
    }
  }
}
