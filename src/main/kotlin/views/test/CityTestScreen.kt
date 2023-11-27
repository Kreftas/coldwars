package views.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import model.builder.CityCardBuilder
import cafe.adriel.voyager.core.screen.Screen
import presentation.card.BuildingCardDisplay
import presentation.card.ItemCardDisplay
import presentation.card.components.resource_provider.MultiResourceProvider
import presentation.components.TopBar
import model.data.Essence
import model.data.ItemCard
import model.data.Resource
import model.data.buildingCards
import model.data.itemCards
import presentation.field.cards.CardColumn
import presentation.field.cards.CardGrid

object CityTestScreen : Screen {

  private val cityCardBuilder = CityCardBuilder()

  @Composable
  override fun Content() {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.fillMaxSize()
    ) {
      TopBar {
        Button(
          onClick = cityCardBuilder::reset,
          content = { Text("Reset") }
        )
      }
      Row {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          modifier = Modifier.weight(1f)
        ) {
          CityDisplay(cityCardBuilder)
        }
        Spacer(Modifier.weight(.2f))
        CardColumn(buildingCards) {
          BuildingCardDisplay(it, onClick = {
            cityCardBuilder.addBuilding(it)
          })
        }
        CardColumn(itemCards) {
          ItemCardDisplay(it, onClick = {
            cityCardBuilder.addCard(it)
          })
        }
      }
    }
  }

  @Composable
  fun CityDisplay(cityCardBuilder: CityCardBuilder) {
    val buildings by cityCardBuilder.buildings.collectAsState()
    val items: MutableList<ItemCard> by cityCardBuilder.itemsFlow.collectAsState()
    val remainingEssence: MutableList<Essence> by cityCardBuilder.remainingEssenceFlow.collectAsState()

    CardGrid(buildings) {card ->
      BuildingCardDisplay(
        buildingCard = card,
        onClick = {
          cityCardBuilder.removeBuilding(card)
        },
        onAbilityClicked = {
          cityCardBuilder.setBuildingAbility(it, card)
        }
      )
    }
    Row {
      items.forEach {
        ItemCardDisplay(it) {
          cityCardBuilder.removeCard(it)
        }
      }
    }
    MultiResourceProvider(Resource.MultiEssence(remainingEssence))

  }

}