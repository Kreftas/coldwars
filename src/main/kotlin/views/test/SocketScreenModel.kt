/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package views.test

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import client.ColdWarsClient
import client.ColdWarsMessage
import client.SocketEvent
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SocketScreenModel : ScreenModel {

  private val client = ColdWarsClient()

  private val messageFlow: SharedFlow<SocketEvent> = client.messageFlow

  val connectionFlow: StateFlow<Boolean> = messageFlow
    .transform {
      when (it) {
        is SocketEvent.Connected -> emit(true)
        is SocketEvent.DisConnected -> emit(false)
        else -> {}
      }
    }
    .stateIn(screenModelScope, SharingStarted.Lazily, false)

  val messageReceivedFlow: StateFlow<List<ColdWarsMessage>> = messageFlow
    .transform {
      println("Transform $it")
      when (it) {
        is SocketEvent.MessageReceived -> emit(ColdWarsMessage(msg = "Received ${it.message}"))
        is SocketEvent.MessageSent -> emit(it.message.copy(msg = "Sent: ${it.message}"))
        is SocketEvent.Connected -> emit(ColdWarsMessage("Connected"))
        is SocketEvent.DisConnected -> emit(ColdWarsMessage("Disconnected"))
        is SocketEvent.Subscribed -> emit(ColdWarsMessage("Subscribed ${it.topic}"))
      }
    }
    .runningFold(emptyList<ColdWarsMessage>()) { list, msg ->
      list.toMutableList().apply { add(msg) }
    }
    .stateIn(screenModelScope, SharingStarted.Lazily, emptyList())

  init {
    messageFlow.onEach { println(it) }.launchIn(screenModelScope)
  }

  fun connect() {
    screenModelScope.launch {
      client.connect()

    }
  }

  fun disconnect() {

  }

  fun sendHello() {
    client.sendHello()
  }

}