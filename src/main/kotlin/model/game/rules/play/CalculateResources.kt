package model.game.rules.play

import model.game.builder.PlayerBuilder
import model.data.Attribute
import model.game.rules.Rule

data class CalculateResources(
  val player: PlayerBuilder,
) : Rule {

  override suspend fun execute() {
    val resources = player.field.resources()
    val goldPoints = resources.sumOf { it.gold() }
    val essences = resources.flatMap { it.essences() }

    val diplomacyEssences = essences.filter { it.attribute == Attribute.Diplomacy }
    val goldEssences = essences.filter { it.attribute == Attribute.Economic }

    val influencePoints = diplomacyEssences.size

    with(player) {
      gold.update(goldPoints)
      essence.updateEssence(essences)
      influence.increaseInfluence(influencePoints)
    }

    val goldModifier = goldEssences.size / 3
    if (goldModifier >= 1) {
      val increasedValue: Double = goldPoints * (goldModifier * 1.5)
      val increasedInt = increasedValue.toInt()
      player.gold.update(increasedInt)
    }
  }

  override suspend fun undo() {

  }
}