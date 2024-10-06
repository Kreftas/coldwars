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
fun OppositePlayerArea(
  deck: @Composable RowScope.() -> Unit,
  status: @Composable ColumnScope.() -> Unit,
) {
  Column(
    modifier = Modifier.fillMaxWidth()
  ) {

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
        content = {  },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
          .weight(.7f)
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

//    Row(
//      verticalAlignment = Alignment.CenterVertically,
//      horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally),
//      content = status,
//      modifier = Modifier
//        .fillMaxWidth()
//        .border(1.dp, MaterialTheme.colorScheme.outline)
//    )
//
//    Row(
//      verticalAlignment = Alignment.CenterVertically,
//      horizontalArrangement = Arrangement.SpaceBetween,
//      modifier = Modifier
//        .fillMaxWidth()
//    ) {
//      Row(
//        horizontalArrangement = Arrangement.End,
//        content = deck,
//        modifier = Modifier
//          .weight(.2f)
//          .cardArea()
//      )
//    }
  }
}