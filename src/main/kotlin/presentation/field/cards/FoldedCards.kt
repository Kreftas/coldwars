/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.card

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.data.BasicCard
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ui.CardDimension
import views.game.PopupDisplay
import views.game.GameScreenModel

private const val ANIM_DURATION = 300
private const val GAP = 10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : BasicCard> FoldedCards(
  cards: Collection<T>,
  onClick: (T) -> Unit,
  cardDimension: CardDimension = CardDimension.Medium,
  content: @Composable (
    card: T,
    cardDimension: CardDimension,
    onClick: (T) -> Unit,
  ) -> Unit,
) {
  var folded by remember { mutableStateOf(true) }
  val scope = rememberCoroutineScope()
  var asBox by remember { mutableStateOf(true) }

  fun onFold(fold: Boolean) {
    folded = fold
    if (!folded)
      scope.launch {
        delay(ANIM_DURATION.toLong())
        asBox = false
      }
    else {
      asBox = true
    }

  }

  if (!folded) {
    Surface(
      onClick = { onFold(true) },
      color = MaterialTheme.colorScheme.primary,
      modifier = Modifier.width(30.dp).height(cardDimension.height)
    ) {
    }
  }
  if (asBox) {
    Box(
      modifier = Modifier.scrollable(
        orientation = Orientation.Horizontal,
        enabled = true,
        state = rememberScrollableState { delta ->
          delta
        }
      )
    ) {
      cards.forEachIndexed { index, card ->
        val padding by remember(folded) {
          mutableStateOf(
            if (!folded) (CardDimension.Medium.width + GAP.dp) * (index)
            else (10 * index).dp
          )
        }
        val paddingAnim by animateDpAsState(padding, tween(ANIM_DURATION))
        Box(
          modifier = Modifier
            .padding(start = paddingAnim)
        ) {
          content(card, cardDimension) {
            if (folded) onFold(false)
            else onClick(it)
          }
        }
      }
    }
  } else
    LazyRow(
      horizontalArrangement = Arrangement.spacedBy(GAP.dp)
    ) {
      cards.forEach {
        item {
          content(it, cardDimension) {
            onClick(it)
          }
        }
      }
    }
}

@Composable
fun FoldedCardTest(screenModel: GameScreenModel) {
  val p1 by screenModel.p1.collectAsState()

  FoldedCards(
    p1.heroes,
    onClick = { screenModel.openModal(PopupDisplay(it)) },
    content = { card, dimensions, onClick ->
      HeroCardDisplay(card, dimensions) {
        onClick(it)
      }
    }
  )
  FoldedCards(
    screenModel.startingCards,
    onClick = { screenModel.openModal(PopupDisplay(it)) },
    content = { card, dimensions, onClick ->
      CardDisplay(
        basicCard = card,
        onClick = { onClick(card) },
        content = {}
      )
    }
  )
}


@Composable
fun <T : BasicCard> FoldableDeck(
  cards: Collection<T>,
  folded: Boolean = true,
  onFold: (Boolean) -> Unit = {},
  cardDimension: CardDimension = CardDimension.Medium,
  onClick: (T) -> Unit = {},
  content: @Composable (
    card: T,
    cardDimension: CardDimension,
    onClick: (T) -> Unit,
  ) -> Unit,
) {
  Box {
    cards.forEachIndexed { index, card ->

      val padding by mutableStateOf(
        if (folded) (GAP * index).dp
        else (CardDimension.Medium.width + GAP.dp) * (index)
      )
      val paddingAnim by animateDpAsState(padding, tween(ANIM_DURATION))

      Box(modifier = Modifier.padding(start = paddingAnim)) {
        content(card, cardDimension) {
          if (folded) onFold(false)
          else onClick(it)
        }
      }
    }
  }
}


//
//@Composable
//private fun <T : BasicCard> AsLazy(
//  folded: Boolean,
//  onFold: (Boolean) -> Unit,
//  cardDimension: CardDimension,
//  cards: Collection<T>,
//  onClick: (T) -> Unit,
//  content: @Composable (
//    presentation.card: T,
//    cardDimension: CardDimension,
//    onClick: (T) -> Unit,
//  ) -> Unit,
//) {
//  LazyRow(
//    horizontalArrangement = Arrangement.spacedBy(GAP.dp)
//  ) {
//    cards.forEach {
//      item {
//        content(it, cardDimension) {
//          onFold(true)
//          onClick(it)
//        }
//      }
//    }
//  }
//}