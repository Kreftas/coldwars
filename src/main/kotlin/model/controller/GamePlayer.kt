/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.controller

import androidx.compose.ui.graphics.Color


data class GamePlayer(
  val name: String,
  val color: Color,
) {
  companion object {
    fun playerOne() = GamePlayer("Player one", Color.Blue)
    fun playerTwo() = GamePlayer("Player two", Color.Red)
  }

}
