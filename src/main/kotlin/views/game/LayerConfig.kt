package views.game

import cafe.adriel.voyager.core.screen.Screen

sealed interface ActionState {
  data object Closed: ActionState
  data class Open(
    val left: ActionScreen,
    val right: ActionScreen,
  ) : ActionState
}

sealed interface ActionScreen {
  val name: String
  data object Hand: ActionScreen {
    override val name: String = "Hand"
  }

  data object City: ActionScreen {
    override val name: String = "City"
  }
  data object Heroes: ActionScreen {
    override val name: String = "Heroes"
  }
}

sealed interface PopupState {
  data object Closed: PopupState
  data class Open(val screen: PopupScreen): PopupState
}

interface PopupScreen: Screen