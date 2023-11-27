/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.field.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.data.BasicCard

@Composable
fun <T : BasicCard> CardRow(
  cards: Collection<T>,
  title: String? = null,
  content: @Composable (T) -> Unit,
) {
  Column(modifier = Modifier.fillMaxWidth()) {
    title?.let {
      Text(title)
    }
    LazyRow(
      horizontalArrangement = Arrangement.spacedBy(5.dp),
      modifier = Modifier.fillMaxWidth()
    ) {
      items(cards.toList()) {
        content(it)
      }
    }
  }
}