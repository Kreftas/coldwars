/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package views.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import model.controller.InGameScreenModel
import model.data.BasicCard
import model.data.StartingGold
import model.data.TradeRowCard
import model.data.TradeRowTest

class GameScreenModel : ScreenModel, InGameScreenModel() {

  var popupState: PopupState by mutableStateOf(PopupState.Closed)
    private set

  var actionState: ActionState by mutableStateOf(ActionState.Closed)
    private set

  val startingCards = listOf<BasicCard>(
    StartingGold, StartingGold, StartingGold, StartingGold, StartingGold,
    StartingGold, StartingGold,
  )

  val currentTradeRowCards = listOf<TradeRowCard>(
    TradeRowTest, TradeRowTest, TradeRowTest, TradeRowTest, TradeRowTest,
  )

  val currentPrivateTradeRowCards = listOf<TradeRowCard>(
    TradeRowTest, TradeRowTest, TradeRowTest
  )

  fun closeAction() {
    actionState = ActionState.Closed
  }

  fun openAction(actionScreen: ActionScreen) {
    actionState = when(actionScreen) {
      is ActionScreen.Hand -> actionState
      is ActionScreen.City -> ActionState.Open(
        left = ActionScreen.Hand,
        right = ActionScreen.City
      )
      is ActionScreen.Heroes -> ActionState.Open(
        left = ActionScreen.Heroes,
        right = ActionScreen.Hand
      )
    }
  }

  fun closePopup() {
    popupState = PopupState.Closed
  }

  fun openModal(popupScreen: PopupScreen) {
    popupState = PopupState.Open(popupScreen)
  }
}