package presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp

fun Modifier.cardArea(): Modifier = composed {
  val cardSize = LocalCardSize.current
  val playerColor = LocalPlayerColor.current
  val padding = 16.dp
  this
    .border(1.dp, playerColor.copy(alpha = 0.5f))
    .heightIn(min = cardSize.height + (padding * 2))
    .widthIn(min = cardSize.width + (padding * 2))
    .padding(padding)
}
