package presentation.field.areas

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import presentation.components.cardArea

@Composable
fun PlayerArea(
  discard: @Composable RowScope.() -> Unit,
  deck: @Composable RowScope.() -> Unit,
  hand: @Composable RowScope.() -> Unit,
  played: @Composable RowScope.() -> Unit,
  status: @Composable ColumnScope.() -> Unit = {},
) {

  Column(
    modifier = Modifier.fillMaxWidth()
  ) {

    /* ------------------ Top row ------------------ */

    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier
        .fillMaxWidth()
    ) {
      Column(
        content = status,
        modifier = Modifier
          .weight(.1f)
          .cardArea()
      )
      Row(
        content = played,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
          .weight(.7f)
          .cardArea()
      )
      Row(
        content = { },
        modifier = Modifier
          .weight(.2f)
          .cardArea()
      )
    }

    /* ------------------ Bottom row ------------------ */

    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier
        .fillMaxWidth()
    ) {
      Row(
        content = discard,
        modifier = Modifier
          .weight(.2f)
          .cardArea()
      )
      Row(
        horizontalArrangement = Arrangement.Center,
        content = hand,
        modifier = Modifier
          .weight(.6f)
          .cardArea()
      )
      Row(
        horizontalArrangement = Arrangement.End,
        content = deck,
        modifier = Modifier
          .weight(.2f)
          .cardArea()
      )
    }
  }
}