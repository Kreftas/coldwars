package presentation.card

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup


data class PopupAction(
  val name: String,
  val action: () -> Unit
)

@Composable
fun CardPopup(
  isShowing: Boolean,
  actions: List<PopupAction>,
  onDismiss: () -> Unit
) {

  if (isShowing) {
    Popup(
      onDismissRequest = onDismiss,
      alignment = Alignment.Center
    ) {
      Surface(
        tonalElevation = 20.dp,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
          .width(200.dp)
          .height(300.dp)
      ) {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.spacedBy(20.dp),
          modifier = Modifier.fillMaxSize()
        ) {
          actions.forEach { action ->
            Button(
              onClick = {
                action.action()
                onDismiss()
              },
              content = {
                Text(action.name)
              }
            )
          }
        }
      }
    }
  }
}