package data

import androidx.compose.ui.graphics.Color

fun Attribute.color(): Color =
  when (this) {
    is Attribute.Technology -> Color.Gray
    is Attribute.Military -> Color.Red
    is Attribute.Diplomacy -> Color.Cyan
    is Attribute.Economic -> Color.Yellow
  }
