package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

enum class CardSizes(val size: Dp) {
  Small(50.dp),
  Medium(100.dp),
  Large(200.dp),
}

@Composable
fun CardContainer(
  modifier: Modifier = Modifier,
  cardSize: CardSizes = CardSizes.Medium,
  onClick: () -> Unit = {},
  content: @Composable ColumnScope.() -> Unit,
) {
  var size: IntSize? by remember(content) { mutableStateOf(null) }

  Box(
    modifier = modifier
      .height(size?.height?.dp ?: Dp.Unspecified)
      .width(size?.width?.dp ?: Dp.Unspecified)
      .clickable { onClick() }
  ) {
    Image(
      painter = painterResource("empty_card_brown.jpg"),
      contentDescription = null,
      modifier = Modifier.width(cardSize.size).onGloballyPositioned {
        size = it.size
        println("SIZE $size")
      }
    )
    size?.let {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
          .fillMaxSize()
          .padding(cardSize.size / 10)
      ) {
        content()
      }
    }
  }
}