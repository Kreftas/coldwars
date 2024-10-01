package presentation.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import model.data.Resource

@Composable
fun ResourceIcon(resource: Resource) {
  when (resource) {
    is Resource.Gold -> GoldRow(resource.amount)
    is Resource.EssenceResource -> EssenceRow(resource.essences)
    Resource.None -> {}
  }
}

@Composable
fun CircleBox(
  color: Color,
  size: Dp = 20.dp,
  content: @Composable BoxScope.() -> Unit = {},
) {
  Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier.size(size).clip(CircleShape).background(color),
    content = content
  )
}