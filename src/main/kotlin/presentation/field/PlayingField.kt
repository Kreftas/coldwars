package presentation.field

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.controller.GamePlayer

@Composable
fun PlayingField(
  playerOne: GamePlayer,
  playerTwo: GamePlayer,
  currentPlayer: GamePlayer,
  info: @Composable RowScope.() -> Unit = {},
  first: @Composable RowScope.() -> Unit = {},
  middle: @Composable RowScope.() -> Unit = {},
  last: @Composable RowScope.() -> Unit = {},
  popupLayer: @Composable BoxScope.() -> Unit = {},
  actionLayer: @Composable BoxScope.() -> Unit = {},
  ) {
  Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface)) {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {

      Row(modifier = Modifier.height(40.dp).fillMaxWidth()) {
        info()
      }

      Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.End),
        modifier = Modifier.fillMaxWidth().weight(.25f)
      ) {
//        PlayerStatus(playerTwo, currentPlayer)
        first()
      }

      Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally),
        modifier = Modifier.fillMaxWidth().weight(.5f)
      ) {
        middle()
      }

      Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxWidth().weight(.25f)
      ) {
        last()
//        PlayerStatus(playerOne, currentPlayer)
      }

    }
    actionLayer()
    popupLayer()
  }
}