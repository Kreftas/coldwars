package client

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.websocket.*
import io.ktor.http.HttpMethod
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.coroutines.channels.ClosedReceiveChannelException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter
import java.lang.Exception
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit

class ColdWarsClient {

  companion object {
    const val SOCKET_ENDPOINT = "ws://localhost:8081/ws"
  }

  private val stompClient = StompClient()


  suspend fun connect() {
    stompClient.connect(SOCKET_ENDPOINT)
    delay(100)
    stompClient.subscribe("/topic/greetings") { message ->
      println("Received message: $message")
    }
  }

  fun disconnect() {

  }

  fun sendHello() {
    stompClient.send("/app/hello", "Hello")
//    stompClient.send("/topic/greetings", "Hello")
  }
}