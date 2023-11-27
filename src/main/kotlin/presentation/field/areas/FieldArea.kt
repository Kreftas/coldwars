/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.field.areas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import views.game.ActionScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RowScope.FieldArea(
  actionScreen: ActionScreen,
  weight: Float,
  onClick: (ActionScreen) -> Unit = {},
  content: @Composable ColumnScope.() -> Unit = {},
) {
  Surface(
    onClick = { onClick(actionScreen) },
    tonalElevation = 4.dp,
    modifier = Modifier
      .fillMaxHeight()
      .weight(weight)
  ) {
    Column(
      modifier = Modifier.fillMaxSize()
    ) {
      Text(actionScreen.name)
      content()
    }

  }
}