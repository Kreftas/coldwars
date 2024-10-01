package views.test

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import model.builder.HeroCardBuilder
import model.data.heroes.HeroDwarf

object HeroTestScreen : Screen {

  private var heroBuilder by mutableStateOf(HeroCardBuilder(heroCard = HeroDwarf))

  @Composable
  override fun Content() {

  }

}