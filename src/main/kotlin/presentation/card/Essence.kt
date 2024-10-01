package presentation.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import model.data.Essence
import model.data.color

@Composable
fun EssenceIcon(essence: Essence) {
  CircleBox(essence.attribute.color(), size = 15.dp)
}

@Composable
fun EssenceRow(essences: List<Essence>) {
  Row(
    horizontalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    essences.forEach { essence ->
      EssenceIcon(essence)
    }
  }
}