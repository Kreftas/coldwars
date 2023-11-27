/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.field

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import model.controller.LogController

@Composable
fun LogSection(
  content: @Composable () -> Unit = {},
) {
  val log by LogController.stateFlow.collectAsState()
  val navigator = LocalNavigator.currentOrThrow

  Row(
    horizontalArrangement = Arrangement.spacedBy(10.dp),
    modifier = Modifier
      .fillMaxWidth()
      .height(100.dp)
  ) {

    content()
  }

}