/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.card.components.resource_provider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import model.data.Essence
import ui.getColor

@Composable
fun EssenceProvider(essence: Essence, amount: Int = 0, size: Dp = 100.dp) {
  ResourceProvider(size = size) {
    Box(Modifier.fillMaxSize().background(essence.getColor()))
  }
}