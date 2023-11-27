package presentation.card

import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import presentation.card.components.ComplexAbilityDisplay
import model.data.HeroAbility
import model.data.HeroCard
import ui.CardDimension

@Composable
fun HeroCardDisplay(
  card: HeroCard,
  cardDimension: CardDimension = CardDimension.Medium,
  onAbilityClicked: (HeroAbility) -> Unit = {},
  onClick: (HeroCard) -> Unit = {},
) {
  CardDisplay(
    card,
    cardDimension = cardDimension,
    onClick = { onClick(card) },
    content = {
      ComplexAbilityDisplay(card.ability1) {
        onAbilityClicked(card.ability1)
      }
      Divider()
      ComplexAbilityDisplay(card.ability2) {
        onAbilityClicked(card.ability2)
      }
      Divider()
      ComplexAbilityDisplay(card.ability3) {
        onAbilityClicked(card.ability3)
      }
    }
  )
}

