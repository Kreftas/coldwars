/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.game.builder

import model.data.Essence
import kotlinx.coroutines.flow.MutableStateFlow
import model.game.collection.CardCollection
import model.data.BasicCard

/* ------------------ State flow list ------------------ */

fun <T> MutableStateFlow<MutableList<T>>.addToFlow(element: T) {
  tryEmit((value + element).toMutableList())
}

fun <T> MutableStateFlow<MutableList<T>>.addToFlow(elements: List<T>) {
  tryEmit((value + elements).toMutableList())
}

fun <T> MutableStateFlow<MutableList<T>>.removeFromFlow(element: T) {
  tryEmit((value - element).toMutableList())
}

fun <T> MutableStateFlow<MutableList<T>>.removeFromFlow(elements: List<T>) {
  elements.forEach {
    tryEmit((value - it).toMutableList())
  }
}

fun <T> MutableStateFlow<MutableList<T>>.clear() {
  tryEmit(mutableListOf())
}

/* ------------------ Card collection ------------------ */

fun <T : BasicCard> List<T>.moveTo(collection: CardCollection<T>) {
  collection.addAll(this)
}

fun <T: BasicCard> T.moveTo(collection: CardCollection<T>) {
  collection.add(this)
}

fun List<Essence>.checkCost(list: List<Essence>): Boolean {
  val mutable = this.toMutableList()
  list.forEach {
    val res = mutable.remove(it)
    if (!res) return false
  }
  return true
}
