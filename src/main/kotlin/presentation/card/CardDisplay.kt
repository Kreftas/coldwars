package presentation.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.data.Attribute
import model.data.BasicCard
import model.data.BuildingCard
import model.data.HeroCard
import model.data.ItemCard
import ui.CardDimension
import ui.CardTheme
import ui.LocalCardDimension
import ui.getTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDisplay(
  basicCard: BasicCard,
  attribute: Attribute? = null,
  detailed: Boolean = true,
  cardDimension: CardDimension = CardDimension.Medium,
  onClick: (() -> Unit)? = null,
  costContent: @Composable RowScope.() -> Unit = {},
  content: @Composable ColumnScope.(cardDimension: CardDimension) -> Unit
) {
  CardTheme(attribute.getTheme()) {
    Card(
      shape = MaterialTheme.shapes.medium,
      border = BorderStroke(4.dp, MaterialTheme.colorScheme.surface),
      modifier = Modifier
        .requiredWidth(cardDimension.width)
        .requiredHeight(cardDimension.height)
    ) {
      Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {

        if (detailed)
          Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
          ) {
            Text(
              text = basicCard.name,
              textAlign = TextAlign.Start,
              style = MaterialTheme.typography.labelLarge,
            )
            costContent()
          }

        if (detailed)
          CardImageTitle(basicCard, cardDimension, onClick)

        if (cardDimension !is CardDimension.Small || !detailed)
          CompositionLocalProvider(
            LocalTextStyle provides MaterialTheme.typography.labelSmall.copy(
              fontSize = cardDimension.fontSize
            ),
            LocalCardDimension provides cardDimension
          ) {
            content(cardDimension)
          }

        Spacer(Modifier.weight(1f))
        val text = when (basicCard) {
          is BuildingCard -> "Building"
          is HeroCard -> "Hero"
          is ItemCard -> "Item"
          else -> ""
        }
        Text(text, fontSize = 6.sp)
      }
    }
  }
}