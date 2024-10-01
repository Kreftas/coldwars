package presentation.field.areas

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import model.controller.GamePlayer

@Composable
fun PlayerStatus(
  gamePlayer: GamePlayer,
  currentPlayer: GamePlayer,
) {

  Column {
    Text(gamePlayer.name)
  }

}