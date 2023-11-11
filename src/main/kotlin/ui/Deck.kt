package ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Deck() {
  Box {
    Box(modifier = Modifier.padding()) {
      CardContainer {  }
    }
    Box(modifier = Modifier.padding(start = 15.dp)) {
      CardContainer {  }
    }
    Box(modifier = Modifier.padding(start = 30.dp)) {
      CardContainer {  }
    }
  }
}