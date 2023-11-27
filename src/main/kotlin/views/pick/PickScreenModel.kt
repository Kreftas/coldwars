/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package views.pick

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import model.controller.DemoController
import model.controller.InGameScreenModel
import model.controller.PlayerController
import model.controller.PlayerController.PlayerEvent
import model.data.HeroCard
import model.data.heroCollection
import kotlin.random.Random

class PickScreenModel: ScreenModel, InGameScreenModel() {

  companion object {
    const val MAX_TURNS = 6
  }

  private var firstPlayer = current.value

  var turn: Int by mutableStateOf(0)
  val heroCards = mutableStateListOf<HeroCard>()

  sealed interface UIEvent {
    data class HeroCardChosen(val heroCard: HeroCard) : UIEvent
  }

  fun initialize(onDemoRun: () -> Unit = {}) {
    firstPlayer = PlayerController.current.value
    turn = 0
    val allHeroes = heroCollection.toMutableList().apply {
      removeAt(Random.nextInt(size))
      removeAt(Random.nextInt(size - 1))
    }
    heroCards.clear()
    heroCards.addAll(allHeroes)
    if (DemoController.demoPick) {
      repeat(MAX_TURNS) {
        onEvent(UIEvent.HeroCardChosen(heroCards[0]))
      }
      onDemoRun()
    }
  }

  fun onEvent(uiEvent: UIEvent) {
    when (uiEvent) {
      is UIEvent.HeroCardChosen -> {
        turn += 1
        heroCards.remove(uiEvent.heroCard)
        with(PlayerController) {
          onEvent(PlayerEvent.Update.AddHero(uiEvent.heroCard))
          if (shouldChangePlayerAfterPick())
            onEvent(PlayerEvent.ChangePlayer)
        }
      }
    }
  }

  private fun shouldChangePlayerAfterPick(): Boolean {

    /*
    0 -> 1 first
    1 -> 2 sec
    2 -> 3 sec
    3 -> 4 first
    4 -> 5 first
    5 -> 6 sec
     */

    // Current player is the first player
    return if (current.value.name == firstPlayer.name) {
      when (turn) {
        1 -> true
        5 -> true
        else -> false
      }
    } else {
      when (turn) {
        3 -> true
        else -> false
      }
    }
  }
}