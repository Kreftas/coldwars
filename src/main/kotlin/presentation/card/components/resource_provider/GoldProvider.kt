/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.card.components.resource_provider

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import model.data.Gold

@Composable
fun GoldProvider(amount: Gold, size: Dp = 100.dp) {
  ResourceProvider(size = size) {
    Image(
      painter = painterResource("gold_coin_single.png"),
      contentDescription = null,
      modifier = Modifier.fillMaxSize()
    )
  }
}