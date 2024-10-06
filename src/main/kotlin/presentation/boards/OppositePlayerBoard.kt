package presentation.boards

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import model.game.builder.PlayerBuilder
import model.data.BasicCard
import presentation.card.CardMould
import presentation.components.LocalPlayerColor
import presentation.field.areas.OppositePlayerArea
import presentation.field.cards.Deck

@Composable
fun OppositePlayerBoard(
  playerBuilder: PlayerBuilder
) {
  val playerCards: MutableList<BasicCard> by playerBuilder.deck.cards.collectAsState()
  val playerHand: MutableList<BasicCard> by playerBuilder.hand.cards.collectAsState()
  val playerPlayedCards: MutableList<BasicCard> by playerBuilder.field.cards.collectAsState()
  val playerDiscard: MutableList<BasicCard> by playerBuilder.discard.cards.collectAsState()
  val playerGold by playerBuilder.gold.gold.collectAsState()
  val playerEssence by playerBuilder.essence.essences.collectAsState()
  val playerInfluence by playerBuilder.influence.influence.collectAsState()

  CompositionLocalProvider(LocalPlayerColor provides playerBuilder.player.color) {
    OppositePlayerArea(
      deck = {
        Deck(playerCards) {
          CardMould(it)
        }
      },
      status = {
        Text("Id: ${playerBuilder.player.name}")
        Text("Influence: $playerInfluence")
      }
    )
  }
}