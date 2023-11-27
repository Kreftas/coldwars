/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package views.pick

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import presentation.card.HeroCardDisplay
import presentation.field.LogSection
import presentation.field.PlayingField
import views.game.GameScreen
import views.menu.MenuScreen

class PickScreen(private val withInit: Boolean = true) : Screen {

  @Composable
  override fun Content() {
    val screenModel: PickScreenModel = rememberScreenModel { PickScreenModel() }
    val p1 by screenModel.p1.collectAsState()
    val p2 by screenModel.p2.collectAsState()
    val current by screenModel.current.collectAsState()

    val navigator = LocalNavigator.currentOrThrow

    LaunchedEffect(Unit) {
      if (withInit)
        screenModel.initialize() {
          navigator.push(GameScreen)
        }
    }

    PlayingField(
      playerOne = p1,
      playerTwo = p2,
      currentPlayer = current,
      info = {
        LogSection(
          content = {
            Button(
              onClick = { navigator.push(MenuScreen) },
              content = { Text("Exit") }
            )
            Text("Current player ${current.name}")
            Text("Turn ${screenModel.turn}")
          }
        )
      },
      middle = {
        screenModel.heroCards.forEach {
          HeroCardDisplay(it) { heroCard ->
            screenModel.onEvent(PickScreenModel.UIEvent.HeroCardChosen(heroCard))
          }
        }
        if (screenModel.heroCards.isEmpty()) {
          Button(
            onClick = { navigator.push(GameScreen) },
            content = { Text("Start game") }
          )
        }
      },
      first = {
        p2.heroes.forEach {
          HeroCardDisplay(it) { }
        }
      },
      last = {
        p1.heroes.forEach {
          HeroCardDisplay(it) { }
        }
      }
    )
  }

  @Composable
  fun InfoSection() {

  }
}