/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package views.menu

import cafe.adriel.voyager.core.model.ScreenModel
import model.controller.PlayerController

class MenuScreenModel : ScreenModel {

  fun initializeGame() {
    PlayerController.onEvent(PlayerController.PlayerEvent.Init)
  }

}