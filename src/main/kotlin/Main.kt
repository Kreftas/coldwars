import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import cafe.adriel.voyager.navigator.Navigator
import ui.AppTheme
import views.menu.MenuScreen
import views.test.CityTestScreen
import views.test.TradeRowTestScreen

@Composable
fun App() {
  AppTheme {
   Surface(
     color = MaterialTheme.colorScheme.surface,
     modifier = Modifier.fillMaxSize()
   ) {
     Navigator(MenuScreen)
   }
  }
}

fun main() = application {
  Window(
    undecorated = false,
    onCloseRequest = ::exitApplication,
    title = "Cold wars",
    state = WindowState(
      size = DpSize.Unspecified,
      placement = WindowPlacement.Fullscreen
    )
  ) {
    App()
  }
}
