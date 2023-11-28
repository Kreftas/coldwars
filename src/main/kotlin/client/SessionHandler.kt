package client

import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter
import java.lang.reflect.Type

class SessionHandler(
  private val onEvent: (event: SocketEvent) -> Unit,
): StompSessionHandlerAdapter() {

  override fun afterConnected(session: StompSession, connectedHeaders: StompHeaders) {
    println("Connected to WebSocket server")
    onEvent(SocketEvent.Connected)
  }

  override fun getPayloadType(headers: StompHeaders): Type {
    return ByteArray::class.java
  }

}