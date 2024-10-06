package model.game

import kotlinx.coroutines.delay

object GameConfig {
  val delay: Long = 200L
}

suspend fun gameDelay() {
  delay(GameConfig.delay)
}