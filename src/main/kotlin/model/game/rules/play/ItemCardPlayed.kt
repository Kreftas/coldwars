package model.game.rules.play

import model.data.ItemCard
import model.game.builder.PlayerBuilder
import model.game.rules.Rule

data class ItemCardPlayed(
  val card: ItemCard,
  val player: PlayerBuilder,
) : Rule {

  override suspend fun execute() {
    val gold = card.gold()
    val essence = card.essences()
    player.gold.increase(gold)
    player.essence.increase(essence)

    InfluenceFromDiplomacy(essence, player).execute()
    GoldModifier(essence, player).execute()
  }

  override suspend fun undo() {}
}

