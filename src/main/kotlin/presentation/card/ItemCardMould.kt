package presentation.card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.data.ItemCard
import model.data.color
import ui.CardDimension
import ui.CardTheme
import ui.getTheme

@Composable
fun ItemCardMould(
  card: ItemCard,
  size: CardDimension = CardDimension.Small,
  onClick: () -> Unit = {},
) {
  CardTheme(card.attribute.getTheme()) {
    Surface(
      tonalElevation = 20.dp
    ) {
      Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
          .size(size.dpSize())
          .clickable { onClick() }
          .padding(16.dp)
      ) {
        Text(card.name, style = MaterialTheme.typography.bodySmall, textAlign = TextAlign.Center)
        Text("Cost: ${card.cost}", style = MaterialTheme.typography.bodySmall)
        ResourceIcon(card.resource)
      }
    }
  }
}