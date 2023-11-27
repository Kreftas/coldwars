package model.data

import java.util.concurrent.atomic.AtomicInteger

/* ------------- Cards ------------- */

const val DEFAULT_IMAGE = "lizard-man.png"
const val DEFAULT_NAME = "Name"

/** Basic presentation.card with a name and image. */
interface BasicCard {
  val name: String
  val imageRes: String
    get() = DEFAULT_IMAGE
}

interface LoreCard {
  val description: String
}


/** A presentation.card that gives victory points. */
interface VictoryPointCard {
  val points: VictoryPoints
}

interface AttributeCard {
  val attribute: Attribute
}

/** A presentation.card that is retrieved from the trade row. */
sealed interface TradeRowCard : BasicCard, BuyAble


/** Cards that the users start with. */
interface StartingCard : BasicCard, ProvidesResources {
  override val name: String
    get() = ""
}

/** A presentation.card that is a hero presentation.card. */
data class HeroCard(
  override val name: String,
  override val imageRes: String,
  val ability1: HeroAbility,
  val ability2: HeroAbility,
  val ability3: HeroAbility,
) : BasicCard

val atomicInteger = AtomicInteger(0)

/** Card that is a building, used to upgrade city. */
data class BuildingCard(
  override val name: String,
  override val imageRes: String = "building_image.jpeg",
  override val points: VictoryPoints,
  override val attribute: Attribute,
  override val cost: Gold,
  val ability: BuildingAbility,
  val silenced: Boolean = false,
  val id: Int = atomicInteger.incrementAndGet()
) : TradeRowCard, AttributeCard, VictoryPointCard

data class ItemCard(
  override val name: String,
  override val imageRes: String = "hat_item.png",
  override val attribute: Attribute,
  override val cost: Gold,
  override val resource: Resource,
) : TradeRowCard, AttributeCard, ProvidesResources

/* ------------- Resources ------------- */

typealias Gold = Int

typealias VictoryPoints = Int

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
  val cost: Gold
}

/** Something that can be upgraded with essence. */
interface UpgradeAble {
  val cost: List<Essence>
  val unlocked: Boolean
}

/* ------------- Abilities ------------- */

interface ProvidesResources {
  val resource: Resource
}

interface ActivateAble {
  val ability: ResourceAbility
}

interface ResourceAbility {
  val types: Set<Resource>
    get() = setOf()
}

/** Basic ability */
interface Ability {
  val name: String
  val description: String
}

sealed interface Resource {
  data class Gold(val amount: Int) : Resource
  data class Essence(val amount: Int, val essence: model.data.Essence) : Resource
  data class MultiEssence(val essences: List<model.data.Essence>) : Resource {
    constructor(attributes: List<Attribute>, kek: String = "") : this(
      attributes.map { model.data.Essence(it) }
    )
  }
}

/** Passive abilities like +2 gold each turn. */
interface PassiveAbility : Ability {

}

/** Card is destroyed after using this ability. */
interface UseOnceAbility : Ability {

}

interface UnlockableAbility {
  val unlocked: Boolean
}

interface ComplexAbility : Ability, UpgradeAble

data class BuildingAbility(
  override val name: String,
  override val description: String,
  override val cost: List<Essence>,
  override val unlocked: Boolean = false
) : ComplexAbility

data class HeroAbility(
  override val cost: List<Essence>,
  override val name: String,
  override val description: String,
  override val unlocked: Boolean = false,
) : ComplexAbility

