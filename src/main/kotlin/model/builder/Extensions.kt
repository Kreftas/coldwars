/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.builder

import model.data.Essence
import model.data.ItemCard
import model.data.Resource
import kotlinx.coroutines.flow.MutableStateFlow

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


fun ItemCard.getEssence(): List<Essence> = when (val res = resource) {
  is Resource.EssenceResource -> res.essences
  else -> emptyList()
}

fun List<Essence>.checkCost(list: List<Essence>): Boolean {
  val mutable = this.toMutableList()
  list.forEach {
    val res = mutable.remove(it)
    if (!res) return false
  }
  return true
}
