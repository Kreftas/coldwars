/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.builder

import model.data.HeroAbility
import model.data.HeroCard
import kotlinx.coroutines.flow.MutableStateFlow

class HeroCardBuilder(private val heroCard: HeroCard) : CardBuilder() {

  /** The hero presentation.card. */
  val heroCardFlow = MutableStateFlow(heroCard)

  fun setHeroAbility(ability: HeroAbility): Boolean {
    return upgradeAbility(ability) {
      setAbility(ability.copy(unlocked = true))
    }
  }

  override fun resetChild() {
    heroCardFlow.tryEmit(heroCard)
  }

  private fun setAbility(heroAbility: HeroAbility): Boolean {
    return when (heroAbility.name) {
      heroCard.ability1.name -> setAbilityOne(heroAbility)
      heroCard.ability2.name -> setAbilityTwo(heroAbility)
      heroCard.ability3.name -> setAbilityThree(heroAbility)
      else -> false
    }
  }

  private fun setAbilityOne(heroAbility: HeroAbility) = updateHero { copy(ability1 = heroAbility) }
  private fun setAbilityTwo(heroAbility: HeroAbility) = updateHero { copy(ability2 = heroAbility) }
  private fun setAbilityThree(heroAbility: HeroAbility) = updateHero { copy(ability3 = heroAbility) }

  private fun updateHero(builder: HeroCard.() -> HeroCard): Boolean {
    return heroCardFlow.tryEmit(with(heroCardFlow.value) { this.builder() })
  }
}
