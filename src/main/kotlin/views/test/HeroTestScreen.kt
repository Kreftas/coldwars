package views.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import model.builder.HeroCardBuilder
import cafe.adriel.voyager.core.screen.Screen
import presentation.card.HeroCardDisplay
import presentation.card.ItemCardDisplay
import presentation.card.components.resource_provider.MultiResourceProvider
import presentation.components.TopBar
import model.data.Essence
import model.data.ItemCard
import model.data.Resource
import model.data.heroCollection
import model.data.heroes.HeroDwarf
import model.data.itemCards
import presentation.field.cards.CardColumn
import ui.CardDimension

object HeroTestScreen : Screen {

  private var heroBuilder by mutableStateOf(HeroCardBuilder(heroCard = HeroDwarf))

  @Composable
  override fun Content() {

    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.fillMaxSize()
    ) {
      TopBar {
        Button(
          onClick = heroBuilder::reset,
          content = { Text("Reset") }
        )
      }
      Row {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          modifier = Modifier.weight(1f)
        ) {
          HeroTest(heroBuilder)
        }
        CardColumn(heroCollection) {
          HeroCardDisplay(it, onClick = {
            heroBuilder = HeroCardBuilder(it)
          })
        }
        CardColumn(itemCards) {
          ItemCardDisplay(it, onClick = {
            heroBuilder.addCard(it)
          })
        }
      }
    }
  }

  @Composable
  private fun HeroTest(heroBuilder: HeroCardBuilder) {

    val heroCard by heroBuilder.heroCardFlow.collectAsState()
    val items: MutableList<ItemCard> by HeroTestScreen.heroBuilder.itemsFlow.collectAsState()
    val remainingEssence: MutableList<Essence> by HeroTestScreen.heroBuilder.remainingEssenceFlow.collectAsState()

    HeroCardDisplay(
      heroCard,
      cardDimension = CardDimension.Large,
      onAbilityClicked = {
        heroBuilder.setHeroAbility(it)
      }
    )
    Row {
      items.forEach {
        ItemCardDisplay(it) {
          heroBuilder.removeCard(it)
        }
      }
    }
    MultiResourceProvider(Resource.MultiEssence(remainingEssence))

  }
}