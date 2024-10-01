/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package views.game

import androidx.compose.runtime.Composable
import model.data.BasicCard
import model.data.HeroCard
import ui.CardDimension

class PopupDisplay<T : BasicCard>(val card: T) : PopupScreen {

  @Composable
  override fun Content() {
    when(card) {
      is HeroCard -> {

      }
      else -> {

      }
    }
  }

}