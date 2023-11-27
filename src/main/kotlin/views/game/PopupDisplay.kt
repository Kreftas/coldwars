/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package views.game

import androidx.compose.runtime.Composable
import presentation.card.HeroCardDisplay
import presentation.card.CardDisplay
import model.data.BasicCard
import model.data.HeroCard
import ui.CardDimension

class PopupDisplay<T : BasicCard>(val card: T) : PopupScreen {

  @Composable
  override fun Content() {
    when(card) {
      is HeroCard -> {
        HeroCardDisplay(card, CardDimension.Large) {}
      }
      else -> {
        CardDisplay(
          basicCard = card,
          onClick = {},
          content = {}
        )
      }
    }
  }

}