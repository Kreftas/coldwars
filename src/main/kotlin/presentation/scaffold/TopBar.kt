/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.scaffold

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

@Composable
fun TopBar(content: @Composable () -> Unit = {}) {
  val navigator = LocalNavigator.currentOrThrow

  Row(
    modifier = Modifier.fillMaxWidth().padding(10.dp)
  ) {
    Button(
      onClick = { navigator.pop() },
      content = { Text("Back") }
    )
    content()
  }

}