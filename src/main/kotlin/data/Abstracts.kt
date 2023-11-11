package data

/* ------------- Cards ------------- */

const val DEFAULT_IMAGE = "male_hero.png"
const val DEFAULT_NAME = "Name"

/** Basic card with a name and image. */
interface BasicCard {
  val name: String
  val imageRes: String
}

/** A card that is a hero card. */
interface HeroCard : BasicCard {
  val ability1: HeroAbility
  val ability2: HeroAbility
  val ability3: HeroAbility
}

/** Each player starts with these cards. */
sealed interface BeginnerCard : BasicCard, ActivateAble {
  data object GoldCard : BeginnerCard {
    override val name: String = "Gold"
    override val imageRes: String = DEFAULT_IMAGE
    override val ability: BasicAbility = object : BasicAbility {
      override val name: String = ""
      override val description: String = ""
    }
  }

  interface ElementalStone : BeginnerCard
  interface Something : BeginnerCard
}

/** A card that gives victory points. */
interface VictoryPointCard {
  val points: Int
}

interface AttributeCard {
  val attribute: Attribute
}

/** A card that is retrieved from the trade row. */
interface TradeRowCard : BasicCard, BuyAble

/** Card that is a building, used to upgrade city. */
interface BuildingCard : TradeRowCard, AttributeCard, VictoryPointCard {
  val ability: PassiveAbility
}

/** Cards that have essence and is used to upgrade buildings or heroes. */
interface ItemCard : TradeRowCard {

}

/* ------------- Resources ------------- */

object Gold


/** All attributes that is in the game. */
sealed interface Attribute {
  data object Economic : Attribute
  data object Military : Attribute
  data object Technology : Attribute
  data object Diplomacy : Attribute
}

/** An essence with an attribute. */
data class Essence(
  val attribute: Attribute
)

/** Something that can be bought with gold. */
interface BuyAble {
  val cost: Int
}

/** Something that can be upgraded with essence. */
interface UpgradeAble {
  val cost: List<Essence>
}

/* ------------- Abilities ------------- */

interface ActivateAble {
  val ability: BasicAbility
}

/** Basic ability */
interface BasicAbility {
  val name: String
  val description: String
}

/** Passive abilities like +2 gold each turn. */
interface PassiveAbility : BasicAbility {

}

/** Card is destroyed after using this ability. */
interface UseOnceAbility : BasicAbility {

}

/** An ability that a hero has. */
interface HeroAbility : BasicAbility, UpgradeAble {
  val used: Boolean
    get() = false
}

/* ------------- Legacy ------------- */

data class TestCard(
  val name: String,
  val heroImage: String = "male_hero.png",
  val abilities: List<TestAbility> = emptyList()
)

data class TestAbility(
  val name: String,
  val description: String,
)