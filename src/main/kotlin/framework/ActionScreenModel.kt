package framework

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

abstract class ActionScreenModel<T>: ScreenModel {

  fun onAction(action: T) {
    handleAction(action)
  }

  fun onActionChain(actions: List<T>, delayBetween: Long = 0L) {
    screenModelScope.launch {
      actions.forEach {
        handleAction(it)
        delay(delayBetween)
      }
    }
  }

  protected abstract fun handleAction(action: T)
}