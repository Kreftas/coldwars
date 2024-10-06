package presentation.card.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GoldIcon(amount: Int) {
  CircleBox(Color.Yellow, size = 15.dp) {
    Text(amount.toString(), color = Color.Black, style = MaterialTheme.typography.bodySmall)
  }
}

@Composable
fun GoldRow(amount: Int) {
  if (amount > 0) {
    GoldIcon(amount)
  }
}