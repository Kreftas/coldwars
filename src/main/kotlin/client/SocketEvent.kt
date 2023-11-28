package client

sealed interface SocketEvent {

  data object Connected : SocketEvent

  data object DisConnected : SocketEvent

  data class Subscribed(val topic: String) : SocketEvent

  data class MessageReceived(val message: ColdWarsMessage) : SocketEvent

  data class MessageSent(val message: ColdWarsMessage) : SocketEvent
}