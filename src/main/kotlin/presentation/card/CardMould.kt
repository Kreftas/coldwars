package presentation.card

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerButton
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import model.data.*
import presentation.card.components.EssenceRow
import presentation.card.components.GoldIcon
import presentation.card.components.GoldRow
import presentation.components.LocalCardSize
import ui.CardDimension
import ui.CardTheme
import ui.getTheme

@Composable
fun CardMould(
  card: BasicCard,
  size: CardDimension = CardDimension.Small,
  onRightClick: () -> Unit = {},
  onClick: () -> Unit = {},
) {
  when (card) {
    is HeroCard -> ImageCard(card, size, onRightClick, onClick)
    is Starters -> ImageCard(card, size, onRightClick, onClick)
    is BuildingCard -> BuildingCardMould(card, onRightClick, onClick)
    is ItemCard -> ItemCardMould(card, onRightClick, onClick)
  }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun AttributeCardMould(
  card: AttributeCard,
  onRightClick: () -> Unit,
  onClick: () -> Unit,
  content: @Composable () -> Unit,
) {
  val size = LocalCardSize.current

  CardTheme(card.attribute.getTheme()) {
    CompositionLocalProvider(LocalTextStyle provides MaterialTheme.typography.bodySmall) {
      Surface(
        content = content,
        tonalElevation = 20.dp,
//        onClick = {},
        modifier = Modifier
          .size(size.dpSize())
          .onClick(
            matcher = PointerMatcher.mouse(PointerButton.Secondary),
            onClick = onRightClick
          )
          .onClick(
            matcher = PointerMatcher.mouse(PointerButton.Primary),
            onClick = onClick
          )
      )
    }
  }
}

@Composable
fun TradeRowCardMould(
  card: TradeRowCard,
  content: @Composable ColumnScope.() -> Unit
) {
  Column(
    verticalArrangement = Arrangement.spacedBy(4.dp),
    modifier = Modifier.padding(4.dp)
  ) {
    Row(
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(
        text = card.name,
        maxLines = 1,
        softWrap = false,
        overflow = TextOverflow.Clip,
        modifier = Modifier.weight(weight = 1.0f, fill = false)
      )
      GoldIcon(card.cost)
    }
    Spacer(Modifier.weight(1f))
    Column(
      verticalArrangement = Arrangement.spacedBy(4.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.fillMaxWidth(),
      content = content
    )
  }
}

@Composable
fun BuildingCardMould(
  card: BuildingCard,
  onRightClick: () -> Unit,
  onClick: () -> Unit,
) {
  AttributeCardMould(card, onRightClick, onClick) {
    TradeRowCardMould(card) {
      Text(card.points.toString())
    }
  }
}

@Composable
fun ItemCardMould(
  card: ItemCard,
  onRightClick: () -> Unit,
  onClick: () -> Unit,
) {
  AttributeCardMould(card, onRightClick, onClick) {
    TradeRowCardMould(card) {
      GoldRow(card.gold())
      EssenceRow(card.essences())
    }
  }
}

@Composable
private fun ImageCard(
  card: BasicCard,
  size: CardDimension = CardDimension.Small,
  onRightClick: () -> Unit,
  onClick: () -> Unit,
) {
  Image(
    painter = painterResource(card.imageRes),
    contentDescription = null,
    modifier = Modifier
      .size(size.dpSize())
      .clickable { onClick() }
  )
}