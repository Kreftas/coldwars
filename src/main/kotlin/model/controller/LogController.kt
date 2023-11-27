package model.controller

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

object LogController {
  private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

  val sharedFlow = MutableSharedFlow<String>()

  val stateFlow = MutableStateFlow<List<String>>(emptyList())

  fun reset() {
    stateFlow.value = emptyList()
  }

  init {
    scope.launch {
      sharedFlow.collect {
        stateFlow.value += it
      }
    }
  }
}