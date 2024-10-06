/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package views.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import views.test.CityTestScreen
import views.test.CollectionScreen
import views.test.HeroTestScreen
import views.pick.PickScreen
import views.test.SocketTest
import views.playground.TradeRowTestScreen

object MenuScreen : Screen {

  @Composable
  override fun Content() {

    val navigator = LocalNavigator.currentOrThrow
    val screenModel = rememberScreenModel { MenuScreenModel() }

    LaunchedEffect(Unit) {
      screenModel.initializeGame()
    }

    Column(
      verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxHeight()
        .requiredWidth(600.dp)
    ) {
      Text("Cold wars", style = MaterialTheme.typography.titleLarge)
      MenuButton("Start game") {
        navigator.push(PickScreen())
      }
      MenuButton("View collection") {
        navigator.push(CollectionScreen)
      }
      MenuButton("Testing hero") {
        navigator.push(HeroTestScreen)
      }
      MenuButton("Testing city") {
        navigator.push(CityTestScreen)
      }
      MenuButton("Testing trade row") {
        navigator.push(TradeRowTestScreen)
      }
      MenuButton("Socket test") {
        navigator.push(SocketTest)
      }
    }
  }

  @Composable
  fun MenuButton(
    label: String,
    onClick: () -> Unit,
  ) {
    Button(
      onClick = onClick,
      content = { Text(label) },
      modifier = Modifier
        .fillMaxWidth()
    )
  }

}

