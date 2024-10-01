/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.field.areas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.data.TradeRowCard


@Composable
fun RowScope.PrivateTradeRowArea(
  p1: List<TradeRowCard>,
  p2: List<TradeRowCard>
) {
  Column(
    verticalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
      .fillMaxHeight()
      .weight(.4f)
      .background(MaterialTheme.colorScheme.secondary)
  ) {
    PrivateTradeRow(p2)
    Spacer(modifier = Modifier.height(10.dp))
    PrivateTradeRow(p1)
  }
}


@Composable
fun ColumnScope.PrivateTradeRow(
  cards: List<TradeRowCard>,
) {
  Row(
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    modifier = Modifier.fillMaxWidth().weight(.5f)
  ) {
    cards.forEach {

    }
  }
}