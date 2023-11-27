package model.data.heroes

import model.data.Attribute
import model.data.DEFAULT_IMAGE
import model.data.Essence
import model.data.HeroAbility
import model.data.HeroCard

val HeroOrc = HeroCard(
  name = "Orc",
  imageRes = DEFAULT_IMAGE,
  ability1 = HeroAbility(
    name = "",
    description = "",
    cost = listOf(
      Essence(Attribute.Military),
      Essence(Attribute.Military),
      Essence(Attribute.Military),
    )
  ),
  ability2 = HeroAbility(
    name = "",
    description = "",
    cost = listOf(
      Essence(Attribute.Military),
      Essence(Attribute.Military),
      Essence(Attribute.Military),
    )
  ),
  ability3 = HeroAbility(
    name = "",
    description = "",
    cost = listOf(
      Essence(Attribute.Military),
      Essence(Attribute.Military),
      Essence(Attribute.Military),
    )
  ),
)