package model.game.rules.play

import model.data.Attribute
import model.data.Essence
import model.game.builder.PlayerBuilder
import model.game.rules.Rule

data class GoldModifier(
  val essences: List<Essence>,
  val player: PlayerBuilder,
): Rule {

  override suspend fun execute() {
    val gold = player.gold.get()
    val goldEssences = essences.filter { it.attribute == Attribute.Economic }
    val goldModifier = goldEssences.size / 3

    if (goldModifier >= 1) {
      val increasedValue: Double = gold * (goldModifier * 1.5)
      val increasedInt = increasedValue.toInt()
      player.gold.update(increasedInt)
    }
  }

  override suspend fun undo() {}
}
