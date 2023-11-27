package views.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import client.ColdWarsClient

object SocketTest: Screen {

  @Composable
  override fun Content() {
    val screenModel = rememberScreenModel { SocketScreenModel() }

    Column(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxSize()
    ) {
      Text("Hej")
      Button(
        onClick = { screenModel.connect() },
        content = { Text("Connect") }
      )
      Button(
        onClick = { screenModel.disconnect() },
        content = { Text("Disconnect") }
      )
      Button(
        onClick = { screenModel.sendHello() },
        content = { Text("Test") }
      )
    }
  }
}