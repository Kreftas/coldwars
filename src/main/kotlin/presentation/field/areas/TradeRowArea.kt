package presentation.field.areas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.data.TradeRowCard
import presentation.card.CardMould
import presentation.components.cardArea

@Composable
fun TradeRowArea(
  tradeRow: @Composable RowScope.() -> Unit,
  cityTradeRow: @Composable RowScope.() -> Unit,
) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
      .fillMaxWidth()
  ) {
    Row(
      content = tradeRow,
      horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .weight(1f)
        .cardArea()
    )
    Row(
      content = cityTradeRow,
      horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .weight(1f)
        .cardArea()
    )
  }
}
