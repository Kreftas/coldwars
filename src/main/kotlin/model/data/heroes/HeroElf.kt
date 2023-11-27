package model.data.heroes

import model.data.Attribute
import model.data.DEFAULT_IMAGE
import model.data.Essence
import model.data.HeroAbility
import model.data.HeroCard

val HeroElf = HeroCard(
  name = "Elf",
  imageRes = DEFAULT_IMAGE,
  ability1 = HeroAbility(
    name = "Gemcrafting",
    description = "",
    cost = listOf(
      Essence(Attribute.Diplomacy),
      Essence(Attribute.Economic),
      Essence(Attribute.Technology),
    )
  ),
  ability2 = HeroAbility(
    name = "Hunting",
    description = "",
    cost = listOf(
      Essence(Attribute.Military),
      Essence(Attribute.Technology),
      Essence(Attribute.Technology),
    )
  ),
  ability3 = HeroAbility(
    name = "Elven tongue",
    description = "",
    cost = listOf(
      Essence(Attribute.Diplomacy),
      Essence(Attribute.Diplomacy),
      Essence(Attribute.Diplomacy),
    )
  ),
)