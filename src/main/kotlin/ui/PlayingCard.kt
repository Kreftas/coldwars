package ui

import androidx.compose.runtime.Composable
import data.TestCard

@Composable
fun PlayingCard(
  card: TestCard,
  cardSize: CardSizes = CardSizes.Large,
  onClick: (TestCard) -> Unit,
) {
  CardContainer(
    cardSize = cardSize,
    onClick = {onClick(card)}
  ) {
    CardContent(card)
  }
}