package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PlayingField(
  info: @Composable () -> Unit,
  first: @Composable () -> Unit,
  middle: @Composable () -> Unit,
  last: @Composable () -> Unit,
) {
  Column(
    verticalArrangement = Arrangement.spacedBy(20.dp),
    modifier = Modifier.fillMaxSize().background(Color.Black)
  ) {

    Row(
      modifier = Modifier.height(60.dp).fillMaxWidth()
    ) {
      info()
    }
    Row(
      horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.End),
      modifier = Modifier.fillMaxWidth().weight(.25f)
    ) {
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
    }

  }
}