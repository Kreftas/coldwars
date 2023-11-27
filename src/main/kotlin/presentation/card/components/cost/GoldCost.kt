/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.card.components.cost

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.data.Gold

@Composable
fun GoldCost(amount: Gold) {
  Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier.clip(CircleShape).requiredSize(20.dp).background(Color.Yellow)
  ) {
//    Image(
//      painter = painterResource("gold_coin_single.png"),
//      contentDescription = null,
//      modifier = Modifier.fillMaxSize()
//    )
    Text(
      amount.toString(),
      color = Color.Black,
      lineHeight = 0.sp
//      modifier = Modifier.clip(CircleShape).padding(10.dp).background(Color.Black)
    )
  }
}