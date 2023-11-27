package views.test

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import presentation.card.BuildingCardDisplay
import presentation.card.HeroCardDisplay
import presentation.card.ItemCardDisplay
import presentation.card.StartingCardDisplay
import presentation.components.TopBar
import model.data.heroCollection
import model.data.buildingCards
import model.data.itemCards
import model.data.startingCardsCollection
import presentation.field.cards.CardRow
import presentation.field.cards.Deck
import ui.CardDimension

object CollectionScreen : Screen {

  @Composable
  override fun Content() {
    val columnState = rememberLazyListState()

    LazyColumn(
      state = columnState,
      modifier = Modifier.fillMaxSize()
    ) {
      item {
        TopBar()
      }
      item {
        Deck(heroCollection) {
          HeroCardDisplay(it, cardDimension = CardDimension.Large)
        }
      }
      item {
        CardRow(buildingCards, "Buildings") {
          BuildingCardDisplay(it, cardDimension = CardDimension.Medium)
        }
      }
      item {
        CardRow(itemCards, "Items") {
          ItemCardDisplay(it, cardDimension = CardDimension.Medium)
        }
      }
      item {
        CardRow(heroCollection, "Heroes") {
          HeroCardDisplay(it, cardDimension = CardDimension.Large)
        }
      }
      item {
        CardRow(heroCollection, "Heroes medium") {
          HeroCardDisplay(it, cardDimension = CardDimension.Medium)
        }
      }
      item {
        CardRow(heroCollection, "Heroes small") {
          HeroCardDisplay(it, cardDimension = CardDimension.Small)
        }
      }
      item {
        CardRow(startingCardsCollection, "Starting cards large") {
          StartingCardDisplay(it, cardDimension = CardDimension.Large)
        }
      }
      item {
        CardRow(startingCardsCollection, "Starting cards medium") {
          StartingCardDisplay(it, cardDimension = CardDimension.Medium)
        }
      }
      item {
        CardRow(startingCardsCollection, "Starting cards small") {
          StartingCardDisplay(it, cardDimension = CardDimension.Small)
        }
      }
    }
  }
}