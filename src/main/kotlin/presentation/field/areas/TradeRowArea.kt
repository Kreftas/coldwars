/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.field.areas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.card.CardDisplay
import model.data.TradeRowCard

@Composable
fun RowScope.TradeRowArea(
  cards: List<TradeRowCard>
) {
  Row(
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .fillMaxHeight()
      .weight(.6f)
      .background(MaterialTheme.colorScheme.secondary)
  ) {
    cards.forEach {
      CardDisplay(it) {

      }
    }
  }
}