package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import data.TestAbility
import data.TestCard

@Composable
fun ColumnScope.CardContent(card: TestCard) {
  Image(
    painter = painterResource(card.heroImage),
    contentDescription = null,
    modifier = Modifier.fillMaxHeight(.5f)
  )
  Column(
    modifier = Modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.Start
  ) {
    Text(
      text = card.name,
      color = Color.White,
      style = MaterialTheme.typography.labelMedium,
    )
    card.abilities.forEach {
      AbilityShowcase(it)
    }
  }
}

@Composable
fun AbilityShowcase(ability: TestAbility) {
  Column(
    modifier = Modifier.fillMaxWidth()
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(Modifier.clip(CircleShape).size(6.dp).background(Color.White))
      Spacer(Modifier.width(10.dp))
      Text(
        text = ability.name,
        color = Color.White,
        style = MaterialTheme.typography.labelSmall,
      )
    }
    Text(
      text = ability.description,
      style = MaterialTheme.typography.labelSmall,
      color = Color.LightGray,
      modifier = Modifier.padding(start = 15.dp)
    )
  }
}