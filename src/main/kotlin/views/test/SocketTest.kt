package views.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen

object SocketTest: Screen {

  @OptIn(ExperimentalMaterial3Api::class)
  @Composable
  override fun Content() {
    val screenModel = rememberScreenModel { SocketScreenModel() }
    val msgFlow by screenModel.messageReceivedFlow.collectAsState()

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
      LazyColumn {
        items(msgFlow) {
          ListItem(headlineText = { Text(it.msg) })
        }
      }
    }
  }
}