package card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import data.BasicCard
import util.Dimensions

@Composable
fun SimpleCard(
  basicCard: BasicCard,
  content: @Composable ColumnScope.() -> Unit
) {
  Card(
    shape = MaterialTheme.shapes.medium,
    modifier = Modifier
      .width(Dimensions.cardWidth)
      .height(Dimensions.cardHeight)
  ) {
    Column(
      modifier = Modifier.fillMaxSize()
    ) {
      Text(
        text = basicCard.name,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(8.dp).fillMaxWidth()
      )
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight(.5f)
          .background(MaterialTheme.colorScheme.primary)
      )
      Column(
        verticalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier.fillMaxSize()
      ) {
        content()
      }
    }
  }
}