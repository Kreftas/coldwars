package views.playground

import cafe.adriel.voyager.core.model.screenModelScope
import framework.ActionScreenModel
import kotlinx.coroutines.launch
import model.game.builder.TradeRowBuilder
import model.game.builder.TurnBuilder
import model.controller.GamePlayer
import model.data.buildingCards
import model.data.itemCards
import model.game.rules.*
import model.game.rules.play.PlayBasicCard
import views.playground.TradeRowTestScreen.Action

class TradeRowTestScreenModel: ActionScreenModel<Action>() {
  private val turnBuilder = TurnBuilder(GamePlayer.playerOne(), GamePlayer.playerTwo())

  val tradeRowBuilder = TradeRowBuilder(itemCards)
  val cityTradeRowBuilder = TradeRowBuilder(buildingCards)

  val currentPlayer = turnBuilder.currentPlayer
  val oppositePlayer = turnBuilder.oppositePlayer

  private val player by currentPlayer::value
  private val opposite by oppositePlayer::value

  init {
    screenModelScope.launch {
      ResetAll(player, opposite, tradeRowBuilder, cityTradeRowBuilder).execute()
    }
  }

  override fun handleAction(action: Action) {
    val rule = when (action) {
      Action.NewTurn -> NewTurn(turnBuilder, player)
      Action.Reset -> ResetAll(player, opposite, tradeRowBuilder, cityTradeRowBuilder)
      is Action.BuyCard -> BuyTradeRowCard(action.card, player, tradeRowBuilder)
      is Action.HandCardClicked -> PlayBasicCard(action.card, player)
      is Action.PlayedCardClicked -> PickUpCard(action.card, player)
    }

    screenModelScope.launch {
      rule.execute()
    }
  }
}