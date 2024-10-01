package framework

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

abstract class IntentScreenModel<I : Any, S>(
  private val initialsState: S
) : StateScreenModel<S>(initialState = initialsState) {
  private var loggingOn: Boolean = true
  
  init {
    log("Model started")
  }
  
  fun onEvent(intent: I) {
    if (!isExcepted(intent::class)) log("On intent: $intent")
    onIntent(intent)
  }
  
  fun onEventChain(intents: List<I>, delayBetween: Long = 0L) {
    screenModelScope.launch {
      intents.forEach {
        onEvent(it)
        delay(delayBetween)
      }
    }
  }
  
  private fun updateState(newState: S) {
    mutableState.value = newState
  }
  
  protected fun clearState() {
    mutableState.value = initialsState
  }
  
  protected fun cancelScope() {
    screenModelScope.cancel()
  }
  
  override fun onDispose() {
    log("Model disposed")
  }
  
  open fun onViewStarted() {
    log("View started")
  }
  
  open fun onViewDisposed() {
    log("View disposed")
  }
  
  protected open fun intentLogExceptList(): List<KClass<*>> = emptyList()
  
  private fun isExcepted(intentEvent: KClass<*>): Boolean {
    return intentLogExceptList().contains(intentEvent)
  }
  
  protected fun updateWith(builder: S.() -> S) {
    updateState(mutableState.value.builder())
  }
  
  protected abstract fun onIntent(intent: I)
  
  protected fun log(any: Any?) {
    if (loggingOn)
      CLog.Builder()
        .clazz(this::class)
        .msg(any)
        .log()
  }
}