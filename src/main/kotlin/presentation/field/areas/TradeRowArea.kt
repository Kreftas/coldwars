package presentation.field.areas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.data.TradeRowCard
import presentation.card.CardMould

@Composable
fun TradeRowArea(
  cards: List<TradeRowCard>,
  onClick: (TradeRowCard) -> Unit,
) {
  Row(
    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .fillMaxWidth()
  ) {
    cards.forEach {
      CardMould(it, onClick = { onClick(it) })
    }
  }
}