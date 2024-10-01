package presentation.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import model.data.color

@Composable
fun GoldIcon(amount: Int) {
  CircleBox(Color.Yellow, size = 20.dp) {
    Text(amount.toString(), color = Color.Black, style = MaterialTheme.typography.bodySmall)
  }
}

@Composable
fun GoldRow(amount: Int) {
  GoldIcon(amount)
}