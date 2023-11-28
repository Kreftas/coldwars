package client

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharedFlow

class ColdWarsClient {

  companion object {
    const val SOCKET_ENDPOINT = "ws://localhost:8081/ws"
  }

  private val stompClient = StompClient()

  val messageFlow: SharedFlow<SocketEvent> = stompClient.messageFlow

  suspend fun connect() {
    stompClient.connect(SOCKET_ENDPOINT)
    delay(100)
    stompClient.subscribe("/topic/greetings")
  }

  fun disconnect() {
    stompClient.disconnect()
  }

  fun sendHello() {
    stompClient.send("/app/hello", ColdWarsMessage("Hello"))
  }
}