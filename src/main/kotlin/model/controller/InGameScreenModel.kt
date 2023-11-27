/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.controller

abstract class InGameScreenModel {

  val p1 = PlayerController.p1
  val p2 = PlayerController.p2
  val current = PlayerController.current

  fun initializeGame() {
    PlayerController.onEvent(PlayerController.PlayerEvent.Init)
  }

}