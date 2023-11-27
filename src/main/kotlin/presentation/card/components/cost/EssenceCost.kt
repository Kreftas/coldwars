/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.card.components.cost

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import model.data.Essence
import model.data.color

@Composable
fun EssenceCost(cost: List<Essence>) {
  Row(
    horizontalArrangement = Arrangement.spacedBy(2.dp)
  ) {
    cost.forEach {
      Dot(it.attribute.color())
    }
  }
}

// TODO: Move
@Composable
fun Dot(color: Color, size: Dp = 8.dp) {
  Box(Modifier.clip(CircleShape).size(size).background(color))
}