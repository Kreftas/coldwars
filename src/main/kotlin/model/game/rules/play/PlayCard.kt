package model.game.rules.play

import model.data.*
import model.game.builder.PlayerBuilder
import model.game.builder.moveTo
import model.game.rules.EmptyRule
import model.game.rules.Rule

sealed class PlayCard(
  open val card: BasicCard,
  open val player: PlayerBuilder,
) : Rule

data class PlayBasicCard(
  override val card: BasicCard,
  override val player: PlayerBuilder,
) : PlayCard(card, player) {

  override suspend  fun execute() {
    with(player) {
      hand.remove(card).moveTo(field)
    }
    val rule = when (card) {
      is HeroCard -> EmptyRule
      is Starters -> StarterCardPlayed(card, player)
      is BuildingCard -> EmptyRule
      is ItemCard -> ItemCardPlayed(card, player)
    }
    rule.execute()
  }

  override suspend fun undo() {
    with(player) {
      field.remove(card).moveTo(hand)
    }
  }
}