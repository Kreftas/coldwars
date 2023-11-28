/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package client

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.springframework.messaging.converter.KotlinSerializationJsonMessageConverter
import org.springframework.messaging.converter.MappingJackson2MessageConverter
import org.springframework.messaging.simp.stomp.StompFrameHandler
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter
import org.springframework.web.socket.client.standard.StandardWebSocketClient
import org.springframework.web.socket.messaging.WebSocketStompClient
import java.lang.Exception
import java.lang.reflect.Type

class StompClient {
  private lateinit var stompSession: StompSession
  private val scope = CoroutineScope(Dispatchers.IO)
  private var connected: Boolean = false
  private val _messageFlow: MutableSharedFlow<SocketEvent> = MutableSharedFlow()
  val messageFlow: SharedFlow<SocketEvent> = _messageFlow.asSharedFlow()

  private val connectionFlow = flow {
    while (currentCoroutineContext().isActive) {
      if (this@StompClient::stompSession.isInitialized) {
        val update = stompSession.isConnected
        if (connected != update) {
          emit(
            if (update) SocketEvent.Connected
            else SocketEvent.DisConnected
          )
        }
        connected = update
      }
      delay(1000)
    }
  }

  init {
    connectionFlow.launchIn(scope)
  }


  fun connect(url: String) {
    val client = StandardWebSocketClient()
    val stompClient = WebSocketStompClient(client)
    stompClient.messageConverter = KotlinSerializationJsonMessageConverter()

    try {
      stompSession = stompClient.connectAsync(url, SessionHandler(::onEvent)).get()
    } catch (e: Exception) {
      println("Connect failed $e")
    }
  }

  fun subscribe(topic: String) {
    try {
      stompSession.subscribe(topic, SubscriptionHandler(topic, ::onEvent))
      println("Subscribed to $topic")
      onEvent(SocketEvent.Subscribed(topic))
    } catch (e: Exception) {
      println("Subscribe failed $e")
    }
  }

  fun send(destination: String, payload: ColdWarsMessage) {
    try {
      stompSession.send(destination, payload)
      onEvent(SocketEvent.MessageSent(payload))
      println("Sent message: $payload to $destination")
    } catch (e: Exception) {
      println("Send failed $e")
    }
  }

  fun disconnect() {
    stompSession.disconnect()
    onEvent(SocketEvent.DisConnected)
  }

  private fun onEvent(event: SocketEvent) {
    println("Emitting $event")
    scope.launch {
      _messageFlow.emit(event)
    }
  }

  // Additional methods for disconnecting, error handling, etc.
}

