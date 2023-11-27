/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package ui

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import model.data.Attribute
import model.data.Essence

fun Modifier.clickableOrNot(onClick: (() -> Unit)? = null): Modifier =
  onClick?.let {
    then(clickable {
      onClick()
    })
  } ?: then(Modifier)


fun Essence.sort(): Int =
  when (this.attribute) {
    is Attribute.Technology -> 4
    is Attribute.Military -> 2
    is Attribute.Diplomacy -> 3
    is Attribute.Economic -> 1
  }
