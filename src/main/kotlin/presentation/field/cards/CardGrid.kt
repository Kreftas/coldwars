/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.field.cards

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import model.data.BasicCard

@Composable
fun <T : BasicCard> CardGrid(
  cards: Collection<T>,
  content: @Composable (T) -> Unit,
) {
  LazyVerticalGrid(
    columns = GridCells.Fixed(5)
  ) {
    items(cards.toList()) {
      content(it)
    }
  }
}