/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.builder

import model.data.BuildingAbility
import model.data.BuildingCard
import kotlinx.coroutines.flow.MutableStateFlow

class CityCardBuilder : CardBuilder() {

  val buildings = MutableStateFlow<MutableList<BuildingCard>>(mutableListOf())

  fun addBuilding(buildingCard: BuildingCard) {
    buildings.addToFlow(buildingCard)
  }

  fun removeBuilding(buildingCard: BuildingCard) {
    buildings.removeFromFlow(buildingCard)
  }

  fun setBuildingAbility(
    ability: BuildingAbility,
    buildingCard: BuildingCard,
  ): Boolean {
    return upgradeAbility(ability) {
      setAbility(ability, buildingCard)
    }
  }
  override fun resetChild() {
    buildings.tryEmit(mutableListOf())
  }

  private fun setAbility(
    ability: BuildingAbility,
    buildingCard: BuildingCard,
  ): Boolean {
    return updateBuildings(buildingCard.copy(
      ability = ability.copy(unlocked = true)
    ))
  }

  /** Removes the old with same name and adds the new. */
  private fun updateBuildings(buildingCard: BuildingCard): Boolean {
    val index = buildings.value.indexOfFirst {
      it.id == buildingCard.id && !it.ability.unlocked
    }
    if (index < 0) return false
    buildings.value[index] = buildingCard
    return true
  }
}
