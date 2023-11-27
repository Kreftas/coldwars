package model.controller

import model.controller.PlayerController.PlayerEvent.ChangePlayer
import model.controller.PlayerController.PlayerEvent.Init
import model.controller.PlayerController.PlayerEvent.Update
import model.data.HeroCard
import kotlinx.coroutines.flow.MutableStateFlow

object PlayerController {
  val p1: MutableStateFlow<GamePlayer> = MutableStateFlow(GamePlayer.playerOne())
  val p2: MutableStateFlow<GamePlayer> = MutableStateFlow(GamePlayer.playerTwo())
  val current: MutableStateFlow<GamePlayer> = MutableStateFlow(p1.value)

  sealed interface PlayerEvent {
    sealed interface Update : PlayerEvent {
      data class AddHero(val heroCard: HeroCard) : Update
    }

    data object ChangePlayer : PlayerEvent
    data object Init : PlayerEvent
  }

  fun onEvent(playerEvent: PlayerEvent) {
    logEvent(playerEvent, current.value)
    when (playerEvent) {
      is Update -> updateCurrentPlayer(with(getCurrentPlayer()) {
        when (playerEvent) {
          is Update.AddHero -> {
            addHero(playerEvent.heroCard)
          }
        }
      })

      is ChangePlayer -> changePlayer()
      is Init -> initialize()
    }
    logPlayers()
  }

  private fun initialize() {
    p1.value = GamePlayer("First")
    p2.value = GamePlayer("Second")
    setRandomPlayer()
  }

  private fun getCurrentPlayer(): GamePlayer =
    if (p1.value.eq(current.value)) p1.value
    else p2.value

  private fun updateCurrentPlayer(gamePlayer: GamePlayer) {
    if (p1.value.eq(current.value)) p1.value = gamePlayer
    else p2.value = gamePlayer
  }

  private fun changePlayer() {
    setPlayer(getNextPlayer())
  }

  private fun getNextPlayer(): GamePlayer =
    if (p1.value.eq(current.value)) p2.value
    else p1.value

  private fun setRandomPlayer() {
    current.value = listOf(p1.value, p2.value).random()
  }

  private fun setPlayer(gamePlayer: GamePlayer) {
    current.value = gamePlayer
  }

  private fun logEvent(playerEvent: PlayerEvent, current: GamePlayer) {
    println("Log event")
    println("For player ${current.name}")
    println("Event: $playerEvent")
    println("")
  }

  private fun logPlayers() {
    println("Log players")
    println(p1.value)
    println(p2.value)
    println(GamePlayer("Test"))
    println("")
  }
}