package views.test

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

object CollectionScreen : Screen {

  @Composable
  override fun Content() {
    val columnState = rememberLazyListState()

  }
}