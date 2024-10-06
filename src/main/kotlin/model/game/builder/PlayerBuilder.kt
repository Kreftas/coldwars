/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.game.builder

import model.game.collection.CardCollection
import model.game.collection.EssenceCollection
import model.game.collection.GoldCollection
import model.game.collection.InfluenceCollection
import model.controller.GamePlayer
import model.data.BasicCard
import model.data.startingCardsCollection
import model.game.Resettable
import model.game.ResettableCollection
import model.game.rules.PlayerReset
import model.game.rules.Rule

class PlayerBuilder(
  val player: GamePlayer
) : Resettable {

  companion object {
    const val CARDS_IN_HAND = 5
  }

  /* ------------------ Resources ------------------ */

  /** The current essences that the user have access to. */
  val influence: InfluenceCollection = InfluenceCollection()

  /** The current essences that the user have access to. */
  val essence: EssenceCollection = EssenceCollection()

  /** The current gold that the user have access to. */
  val gold: GoldCollection = GoldCollection()

  val resources: List<ResettableCollection> = listOf(gold, essence, influence)

  /* ------------------ Cards ------------------ */

  /** The cards in the users deck. */
  val deck: CardCollection<BasicCard> = CardCollection()

  /** The cards in the users discard pile. */
  val discard: CardCollection<BasicCard> = CardCollection()

  /** The cards in the users hand. */
  val hand: CardCollection<BasicCard> = CardCollection()

  /** The cards that the player have played this turn. */
  val field: CardCollection<BasicCard> = CardCollection()

  val all: List<CardCollection<BasicCard>> = listOf(deck, discard, hand, field)

  /* ------------------ Card actions ------------------ */

  override fun resetRule(): Rule = PlayerReset(this, startingCardsCollection)

}