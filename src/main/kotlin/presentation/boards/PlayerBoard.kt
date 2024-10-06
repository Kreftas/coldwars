package presentation.boards

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import framework.OnAction
import model.game.builder.PlayerBuilder
import model.data.BasicCard
import presentation.card.CardMould
import presentation.card.CardPopup
import presentation.card.PopupAction
import presentation.card.components.EssenceRow
import presentation.components.LocalPlayerColor
import presentation.field.areas.PlayerArea
import presentation.field.cards.CardRow
import presentation.field.cards.Deck
import views.playground.TradeRowTestScreen.Action

@Composable
fun PlayerBoard(
  playerBuilder: PlayerBuilder,
  onAction: OnAction<Action>,
) {
  var isShowingPopup by remember { mutableStateOf(false) }
  val playerCards: MutableList<BasicCard> by playerBuilder.deck.cards.collectAsState()
  val playerHand: MutableList<BasicCard> by playerBuilder.hand.cards.collectAsState()
  val playerPlayedCards: MutableList<BasicCard> by playerBuilder.field.cards.collectAsState()
  val playerDiscard: MutableList<BasicCard> by playerBuilder.discard.cards.collectAsState()
  val playerGold by playerBuilder.gold.gold.collectAsState()
  val playerEssence by playerBuilder.essence.essences.collectAsState()
  val playerInfluence by playerBuilder.influence.influence.collectAsState()

  CompositionLocalProvider(LocalPlayerColor provides playerBuilder.player.color) {
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
          CardPopup(
            isShowing = isShowingPopup,
            actions = listOf(
              PopupAction("Discard", action = { onAction(Action.HandCardClicked(it)) })
            ),
            onDismiss = {
              isShowingPopup = false
            }
          )
          CardMould(
            card = it,
            onRightClick = {
              isShowingPopup = true
            },
            onClick = {
              isShowingPopup = true
//              onAction(Action.HandCardClicked(it))
            }
          )
        }
      },
      played = {
        CardRow(playerPlayedCards) {
          CardMould(it) {
            onAction(Action.PlayedCardClicked(it))
          }
        }
      },
      status = {
        Text("Id: ${playerBuilder.player.name}")
        Text("Influence: $playerInfluence")
        Text("Gold: $playerGold")
        EssenceRow(playerEssence)
      }
    )
  }
}