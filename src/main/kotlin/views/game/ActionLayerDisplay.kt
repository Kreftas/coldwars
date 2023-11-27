/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package views.game

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RowScope.ActionLayerDisplay(
  actionScreen: ActionScreen
) {
  Column(
    modifier = Modifier
      .fillMaxHeight()
      .weight(.5f)
  ) {
    when(actionScreen) {
      is ActionScreen.Hand -> Hand(actionScreen)
      is ActionScreen.City -> City(actionScreen)
      is ActionScreen.Heroes -> Heroes(actionScreen)
    }
  }
}

@Composable
private fun Hand(actionScreen: ActionScreen.Hand) {
  Text("Hand")
}

@Composable
private fun City(actionScreen: ActionScreen.City) {
  Text("City")

}

@Composable
private fun Heroes(actionScreen: ActionScreen.Heroes) {
  Text("Heroes")

}