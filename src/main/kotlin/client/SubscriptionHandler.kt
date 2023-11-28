package client

import org.springframework.messaging.simp.stomp.StompFrameHandler
import org.springframework.messaging.simp.stomp.StompHeaders
import java.lang.reflect.Type

class SubscriptionHandler(
  private val topic: String,
  private val onEvent: (event: SocketEvent) -> Unit,
) : StompFrameHandler {

  override fun getPayloadType(headers: StompHeaders): Type {
    return ColdWarsMessage::class.java
  }

  override fun handleFrame(headers: StompHeaders, payload: Any?) {
    val p = payload as ColdWarsMessage
    println("Received message: $p on topic: $topic")
    onEvent(SocketEvent.MessageReceived(p))
  }
}