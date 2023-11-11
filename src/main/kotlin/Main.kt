import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import card.HeroCard
import card.SimpleCard
import data.HeroElf
import data.TestCard
import data.cardCollection
import data.heroElf
import ui.*
import kotlin.random.Random

@Composable
@Preview
fun App(content: @Composable () -> Unit) {

  val cards: SnapshotStateList<TestCard> = remember { mutableStateListOf() }
  val firstPlayer: SnapshotStateList<TestCard> = remember { mutableStateListOf() }
  val secondPlayer: SnapshotStateList<TestCard> = remember { mutableStateListOf() }

  var firstPlayerTurn by mutableStateOf(true)


  fun init() {
    firstPlayer.clear()
    secondPlayer.clear()
    cards.clear()
    val size = cardCollection.size
    val pool = cardCollection.toMutableList().apply {
      removeAt(Random.nextInt(size))
      removeAt(Random.nextInt(size - 1))
    }
    cards.addAll(pool)
  }

  LaunchedEffect(Unit) {
    init()
  }


  fun onChose(card: TestCard) {
    cards.remove(card)
    if (firstPlayerTurn) {
      firstPlayer.add(card)
    } else {
      secondPlayer.add(card)
    }
    firstPlayerTurn = !firstPlayerTurn
  }

  MaterialTheme(
    colorScheme = darkColorScheme()
  ) {
    PlayingField(
      info = {
        Text(if (firstPlayerTurn) "First player turn" else "Second player turn", color = Color.White)
        Button(
          onClick = {
            init()
          },
          content = {
            Text("Reset")
          }
        )
      },
      first = {
        firstPlayer.forEach {
          PlayingCard(it) { card -> }
        }
        Spacer(Modifier.width(30.dp))
        Deck()
      },
      middle = {
        HeroCard(HeroElf())
      },
      last = {
        Deck()
        Spacer(Modifier.width(30.dp))
        secondPlayer.forEach {
          PlayingCard(it) { card -> }
        }
      }
    )
  }
}

fun main() = application {
  Window(
    undecorated = false,
    onCloseRequest = ::exitApplication,
    title = "Cold wars",
    state = WindowState(
      size = DpSize.Unspecified,
      placement = WindowPlacement.Maximized
    )
  ) {
    App {

    }
  }
}
