package views.playground

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import model.data.BasicCard
import model.data.TradeRowCard
import presentation.boards.OppositePlayerBoard
import presentation.boards.PlayerBoard
import presentation.boards.TradeRowBoard
import presentation.scaffold.TopBar

object TradeRowTestScreen : Screen {

  sealed interface Action {
    data object Reset : Action
    data object NewTurn : Action
    data class BuyCard(val card: TradeRowCard) : Action
    data class HandCardClicked(val card: BasicCard) : Action
    data class PlayedCardClicked(val card: BasicCard) : Action
  }

  @Composable
  override fun Content() {
    val screenModel = rememberScreenModel { TradeRowTestScreenModel() }
    val player by screenModel.currentPlayer.collectAsState()
    val oppositePlayer by screenModel.oppositePlayer.collectAsState()

    Column(
      modifier = Modifier.fillMaxSize()
    ) {
      TopBar {
        Button(
          onClick = { screenModel.onAction(Action.Reset) },
          content = { Text("Reset") }
        )
        Button(
          onClick = { screenModel.onAction(Action.NewTurn) },
          content = { Text("Next turn") }
        )
      }

      OppositePlayerBoard(oppositePlayer)
      Spacer(Modifier.weight(1f))
      TradeRowBoard(
        tradeRowBuilder = screenModel.tradeRowBuilder,
        cityTradeRowBuilder = screenModel.cityTradeRowBuilder,
        onAction = screenModel::onAction
      )
      Spacer(Modifier.weight(1f))
      PlayerBoard(
        playerBuilder = player,
        onAction = screenModel::onAction
      )
    }
  }
}
