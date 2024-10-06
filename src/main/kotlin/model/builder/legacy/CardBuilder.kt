/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.builder.legacy

import model.data.ComplexAbility
import model.data.Essence
import model.data.ItemCard
import kotlinx.coroutines.flow.MutableStateFlow
import model.game.builder.addToFlow
import model.game.builder.checkCost
import model.game.builder.removeFromFlow

/** Handles adding item cards and checking the essence cost of stuff. */
abstract class CardBuilder {
  /** The current items in this model.builder. */
  val itemsFlow = MutableStateFlow<MutableList<ItemCard>>(mutableListOf())

  /** The remaining essence available in this model.builder. */
  val remainingEssenceFlow = MutableStateFlow<MutableList<Essence>>(mutableListOf())

  fun reset() {
    itemsFlow.tryEmit(mutableListOf())
    remainingEssenceFlow.tryEmit(mutableListOf())
    resetChild()
  }

  /** Adds a cards and calculates the remaining essence. */
  fun addCard(itemCard: ItemCard) {
    itemsFlow.addToFlow(itemCard)
//    remainingEssenceFlow.addToFlow(itemCard.getEssence())
  }

  /** Removes a cards and calculates the remaining essence. */
  fun removeCard(itemCard: ItemCard) {
    itemsFlow.removeFromFlow(itemCard)
//    remainingEssenceFlow.removeFromFlow(itemCard.getEssence())
  }

  /** Updates an [ability] using [setAbility] after checking that its allowed. */
  protected fun upgradeAbility(
    ability: ComplexAbility,
    updateAbility: (ability: ComplexAbility) -> Boolean,
  ): Boolean {
    if (ability.unlocked) return false

    val cost = ability.cost
    val canUpgrade = remainingEssenceFlow.value.checkCost(cost)
    if (!canUpgrade) return false

    if (updateAbility(ability)) {
      remainingEssenceFlow.removeFromFlow(cost)
      return true
    }

    return false
  }

  abstract fun resetChild()
}
