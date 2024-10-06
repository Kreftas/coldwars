/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package model.game.builder

import model.game.collection.CardCollection
import model.data.TradeRowCard
import model.game.Resettable
import model.game.rules.Rule
import model.game.rules.TradeRowReset

class TradeRowBuilder(
  private val cards: List<TradeRowCard>
) : Resettable {

  val row: CardCollection<TradeRowCard> = CardCollection()
  val deck: CardCollection<TradeRowCard> = CardCollection()

  override fun resetRule(): Rule = TradeRowReset(this, cards)
}