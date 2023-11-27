/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.field.cards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.data.BasicCard

@Composable
fun <T : BasicCard> Deck(
  cards: Collection<T>,
  title: String? = null,
  content: @Composable (T) -> Unit,
) {
  val gap = 10
  Column {
    title?.let {
      Text(title)
    }
    Box {
      cards.forEachIndexed { index, card ->
        Box(modifier = Modifier.padding(start = (gap * index).dp)) {
          content(card)
        }
      }
    }
  }
}