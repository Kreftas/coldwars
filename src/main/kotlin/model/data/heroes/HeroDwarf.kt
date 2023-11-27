package model.data.heroes

import model.data.Attribute
import model.data.DEFAULT_IMAGE
import model.data.Essence
import model.data.HeroAbility
import model.data.HeroCard

val HeroDwarf = HeroCard(
  name = "Dwarf",
  imageRes = DEFAULT_IMAGE,
  ability1 = HeroAbility(
    name = "Smash",
    description = "",
    cost = listOf(
      Essence(Attribute.Military),
      Essence(Attribute.Military),
      Essence(Attribute.Technology),
    )
  ),
  ability2 = HeroAbility(
    name = "Grab",
    description = "",
    cost = listOf(
      Essence(Attribute.Economic),
      Essence(Attribute.Economic),
      Essence(Attribute.Technology),
    )
  ),
  ability3 = HeroAbility(
    name = "Stonk",
    description = "",
    cost = listOf(
      Essence(Attribute.Military),
      Essence(Attribute.Technology),
      Essence(Attribute.Diplomacy),
    )
  ),
)