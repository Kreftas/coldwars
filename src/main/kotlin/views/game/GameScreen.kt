/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package views.game

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import presentation.card.FoldableDeck
import presentation.card.HeroCardDisplay
import model.controller.GamePlayer
import presentation.field.LogSection
import presentation.field.PlayingField
import presentation.field.areas.FieldArea
import presentation.field.areas.PrivateTradeRowArea
import presentation.field.areas.TradeRowArea
import views.pick.PickScreen

object GameScreen : Screen {

  @Composable
  override fun Content() {
    val screenModel = rememberScreenModel { GameScreenModel() }
    val p1 by screenModel.p1.collectAsState()
    val p2 by screenModel.p2.collectAsState()
    val current by screenModel.current.collectAsState()
    val navigator = LocalNavigator.currentOrThrow

    PlayingField(
      playerOne = p1,
      playerTwo = p2,
      currentPlayer = current,
      info = {
        LogSection {
          Button(
            onClick = { navigator.push(PickScreen(false)) },
            content = { Text("Back") }
          )
        }
      },
      middle = { Middle(screenModel) },
      first = { First(screenModel) },
      last = { Last(screenModel) },
      popupLayer = { PopupLayer(screenModel) },
      actionLayer = { ActionLayer(screenModel) }
    )
  }

  @Composable
  fun RowScope.Middle(screenModel: GameScreenModel) {
    TradeRowArea(screenModel.currentTradeRowCards)
    PrivateTradeRowArea(
      p1 = screenModel.currentPrivateTradeRowCards,
      p2 = screenModel.currentPrivateTradeRowCards,
    )
  }

  @Composable
  fun RowScope.First(screenModel: GameScreenModel) {
    val player by screenModel.p2.collectAsState()
    PlayerSection(player, screenModel)
  }

  @Composable
  fun RowScope.Last(screenModel: GameScreenModel) {
    val player by screenModel.p1.collectAsState()
    PlayerSection(player, screenModel)
  }

  @Composable
  fun RowScope.PlayerSection(
    player: GamePlayer,
    screenModel: GameScreenModel
  ) {
    FieldArea(
      actionScreen = ActionScreen.Heroes,
      weight = .25f,
      onClick = screenModel::openAction
    ) {
      FoldableDeck(
        cards = player.heroes,
      ) { card, cardDimension, onClick ->
        HeroCardDisplay(card, cardDimension, onClick = onClick)
      }
    }
    FieldArea(
      actionScreen = ActionScreen.Hand,
      weight = .5f,
    ) {

    }
    FieldArea(
      actionScreen = ActionScreen.City,
      weight = .25f,
      onClick = screenModel::openAction
    )
  }

  @Composable
  fun BoxScope.ActionLayer(screenModel: GameScreenModel) {
    when (val state = screenModel.actionState) {
      is ActionState.Closed -> {}
      is ActionState.Open -> {
        Popup(
          focusable = true,
          alignment = Alignment.Center,
          onDismissRequest = screenModel::closeAction,
        ) {
          Surface(
            tonalElevation = 8.dp,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
              .fillMaxSize(.8f)
          ) {
            Row {
              ActionLayerDisplay(state.left)
              ActionLayerDisplay(state.right)
            }
          }
        }
      }
    }
  }

  @Composable
  fun PopupLayer(screenModel: GameScreenModel) {
    when (val state = screenModel.popupState) {
      is PopupState.Closed -> {}
      is PopupState.Open -> {
        Popup(
          focusable = true,
          alignment = Alignment.Center,
          onDismissRequest = screenModel::closePopup,
        ) {
          Navigator(state.screen)
        }
      }
    }
  }
}