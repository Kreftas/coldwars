/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.card.components.resource_provider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.data.Resource
import ui.sort

@Composable
fun MultiResourceProvider(resource: Resource) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(4.dp, alignment = Alignment.CenterHorizontally),
    modifier = Modifier.fillMaxWidth().padding(4.dp)
  ) {

    when (resource) {
      is Resource.MultiEssence -> {
        resource.essences.sortedBy { it.sort() }.forEach {
          EssenceProvider(it, size = 30.dp)
        }
      }
      is Resource.Gold -> {
        repeat(resource.amount) {
          GoldProvider(1, size = 30.dp)
        }
      }
      else -> {}
    }
  }
}