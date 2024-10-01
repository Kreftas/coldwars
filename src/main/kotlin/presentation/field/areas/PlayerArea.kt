package presentation.field.areas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PlayerArea(
  discard: @Composable RowScope.() -> Unit,
  deck: @Composable RowScope.() -> Unit,
  hand: @Composable RowScope.() -> Unit,
  played: @Composable RowScope.() -> Unit,
  status: @Composable RowScope.() -> Unit = {},
) {

  Column(
    modifier = Modifier.fillMaxWidth()
  ) {

    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally),
      content = status,
      modifier = Modifier.fillMaxWidth()
    )

    Row(
      content = played,
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center,
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    )

    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
      Row(
        content = discard,
        modifier = Modifier
          .weight(.2f)
      )
      Row(
        horizontalArrangement = Arrangement.Center,
        content = hand,
        modifier = Modifier
          .weight(.6f)
      )
      Row(
        horizontalArrangement = Arrangement.End,
        content = deck,
        modifier = Modifier
          .weight(.2f)
      )
    }
  }
}