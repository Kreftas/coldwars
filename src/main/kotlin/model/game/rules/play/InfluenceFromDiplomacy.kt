package model.game.rules.play

import model.data.Attribute
import model.data.Essence
import model.game.builder.PlayerBuilder
import model.game.rules.Rule

data class InfluenceFromDiplomacy(
  val essences: List<Essence>,
  val player: PlayerBuilder,
) : Rule {

  override suspend fun execute() {
    val diplomacyEssences = essences.filter { it.attribute == Attribute.Diplomacy }
    val influencePoints = diplomacyEssences.size
    player.influence.increaseInfluence(influencePoints)
  }

  override suspend fun undo() {}
}
