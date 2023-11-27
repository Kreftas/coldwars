/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.card.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import presentation.card.components.cost.EssenceCost
import model.data.ComplexAbility

@Composable
fun ComplexAbilityDisplay(
  complexAbility: ComplexAbility,
  onClick: () -> Unit = {},
) {
  val color =
    if (complexAbility.unlocked) MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp) else Color.Unspecified

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(color)
      .padding(horizontal = 0.dp, vertical = 2.dp)
      .clickable { onClick() }
  ) {
    Row(
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(
        text = complexAbility.name,
        style = LocalTextStyle.current
      )
      EssenceCost(complexAbility.cost)
    }
    Row(
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(
        text = complexAbility.description,
        style = LocalTextStyle.current
      )
    }
  }
}