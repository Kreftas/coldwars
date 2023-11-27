/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.field.cards

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import model.data.BasicCard

@Composable
fun <T : BasicCard> CardColumn(
  cards: Collection<T>,
  content: @Composable (T) -> Unit,
) {
  LazyColumn(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
  ) {
    items(cards.toList()) {
      content(it)
    }
  }
}