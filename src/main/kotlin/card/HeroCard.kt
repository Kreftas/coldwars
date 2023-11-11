package card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import data.Essence
import data.HeroAbility
import data.HeroCard
import data.color

@Composable
fun HeroCard(
  card: HeroCard
) {
  SimpleCard(card) {
    HeroAbility(card.ability1)
    Divider()
    HeroAbility(card.ability2, true)
    Divider()
    HeroAbility(card.ability3)
  }
}

@Composable
fun HeroAbility(
  heroAbility: HeroAbility,
  used: Boolean = false,
) {
  val color = if (used) MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp) else Color.Unspecified

  Column(
    modifier = Modifier.fillMaxWidth().background(color).padding(8.dp)
  ) {
    Row(
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(
        text = heroAbility.name,
        style = MaterialTheme.typography.labelMedium
      )
      EssenceCost(heroAbility.cost)
    }
    Row(
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(
        text = heroAbility.description,
        style = MaterialTheme.typography.labelSmall
      )
    }
  }
}

@Composable
fun EssenceCost(cost: List<Essence>) {
  Row(
    horizontalArrangement = Arrangement.spacedBy(2.dp)
  ) {
    cost.forEach {
      Dot(it.attribute.color())
    }
  }
}

// TODO: Move
@Composable
fun Dot(color: Color, size: Dp = 20.dp) {
  Box(Modifier.clip(CircleShape).size(size).background(color))
}