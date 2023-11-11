package data

val heroElf = object : HeroCard {
  override val name: String = "Elf"
  override val imageRes: String = DEFAULT_IMAGE
  override val ability1: HeroAbility = object : HeroAbility {
    override val name: String = "Cunning"
    override val description: String = "Does something"
    override val cost: List<Essence> = listOf(
      Essence(Attribute.Technology),
      Essence(Attribute.Diplomacy),
      Essence(Attribute.Diplomacy),
    )
  }
  override val ability2: HeroAbility = object : HeroAbility {
    override val name: String = "Hunting"
    override val description: String = "Does something"
    override val cost: List<Essence> = listOf(
      Essence(Attribute.Technology),
      Essence(Attribute.Military),
      Essence(Attribute.Military),
    )
  }
  override val ability3: HeroAbility = object : HeroAbility {
    override val name: String = "Dark magic"
    override val description: String = "Does something"
    override val cost: List<Essence> = listOf(
      Essence(Attribute.Military),
      Essence(Attribute.Diplomacy),
      Essence(Attribute.Diplomacy),
    )
  }
}

data class HeroElf(
  override val name: String = "Elf",
  override val imageRes: String = DEFAULT_IMAGE,
) : HeroCard {
  override val ability1: HeroAbility = object : HeroAbility {
    override val name: String = "Cunning"
    override val description: String = "Does something"
    override val cost: List<Essence> = listOf(
      Essence(Attribute.Technology),
      Essence(Attribute.Diplomacy),
      Essence(Attribute.Diplomacy),
    )
  }
  override val ability2: HeroAbility = object : HeroAbility {
    override val name: String = "Hunting"
    override val description: String = "Does something"
    override val cost: List<Essence> = listOf(
      Essence(Attribute.Technology),
      Essence(Attribute.Military),
      Essence(Attribute.Military),
    )
  }
  override val ability3: HeroAbility = object : HeroAbility {
    override val name: String = "Dark magic"
    override val description: String = "Does something"
    override val cost: List<Essence> = listOf(
      Essence(Attribute.Military),
      Essence(Attribute.Diplomacy),
      Essence(Attribute.Diplomacy),
    )
  }
}


val elf = TestCard(
  name = "Elf",
  heroImage = "female_hero.png",
  abilities = listOf(
    TestAbility("Hide", "Hide from enemies")
  )
)

val dwarf = TestCard(
  name = "Dwarf",
  abilities = listOf(
    TestAbility("Break rock", "Once per turn, get one rock"),
    TestAbility("Drink ale", "You are stunned but might receive a buff")
  )
)

val human = TestCard(
  name = "Human",
  abilities = listOf(
    TestAbility("Cunning", "Extra knowledge"),
    TestAbility("Greed", "All or nothing")
  )
)

val troll = TestCard(
  name = "Troll",
  abilities = listOf(

  )
)

val gnome = TestCard(
  name = "Gnome",
  abilities = listOf(

  )
)

val orc = TestCard(
  name = "Orc",
  abilities = listOf(

  )
)

val fairy = TestCard(
  name = "Fairy",
  abilities = listOf(

  )
)

val tagrui = TestCard(
  name = "Tagrui",
  abilities = listOf(

  )
)

val cardCollection = listOf(
  elf, dwarf, human, troll, tagrui, orc, gnome, fairy
)